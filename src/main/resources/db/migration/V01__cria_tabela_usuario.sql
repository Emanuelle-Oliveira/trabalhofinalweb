CREATE TABLE public.usuario
(
    id bigserial NOT NULL,
    nome text,
    email text,
    telefone text,
    cidade text,
    uf text,
    cnpj text,
    cpf text,
    categoria text,
    tipo_usuario text,
    status text DEFAULT 'ATIVO',
    PRIMARY KEY (id)
);