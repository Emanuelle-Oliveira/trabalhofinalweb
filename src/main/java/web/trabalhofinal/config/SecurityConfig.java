package web.trabalhofinal.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import web.trabalhofinal.model.Post;

@Configuration
public class SecurityConfig {

	@Autowired
	private DataSource dataSource;
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.antMatchers("/css/**", "/js/**", "/images/**", "/", "/index.html").permitAll()	
			.antMatchers("/ej/abrirpesquisar", "ej/pesquisar", "ej/visualizar").permitAll()	
			.antMatchers("/ej/abrircadastrar", "/ej/cadastrar").hasRole("ADMIN")
			.antMatchers("/ej/abriratualizar", "/ej/atualizar").hasRole("ADMIN")
			.antMatchers("/ej/remover").hasRole("ADMIN")
			.antMatchers("/post/listar").authenticated()
			.antMatchers("/post/abrircadastrar", "/post/cadastrar").hasRole("CLIENTE")
			.antMatchers("/proposta/abrircadastrar", "/proposta/cadastrar").hasRole("EJ")
			.antMatchers("/relatorio").hasRole("ADMIN")
			.and()
		.formLogin()
		.and()
		.logout()
		.logoutSuccessUrl("/");
        return http.build();
    }
    
    @Bean
	public UserDetailsService userDetailsService() {
		JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
		manager.setUsersByUsernameQuery(
				"select email, senha, ativo " + "from usuario " + "where email = ?");
		manager.setAuthoritiesByUsernameQuery("SELECT tab.email , papel.nome FROM"
				+ "(SELECT usuario.email, usuario.id FROM usuario WHERE email = ?) as tab "
				+ " INNER JOIN usuario_papel ON id_usuario = tab.id "
				+ " INNER JOIN papel ON id_papel = papel.id;");
		return manager;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		String idEnconder = "argon2";
		
		Map<String, PasswordEncoder> encoders = new HashMap<>();
		encoders.put("argon2", new Argon2PasswordEncoder());
		PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder(idEnconder, encoders);
		return passwordEncoder;
	}

	
	
}