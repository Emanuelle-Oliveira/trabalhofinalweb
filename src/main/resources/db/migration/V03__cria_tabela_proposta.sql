CREATE TABLE public.proposta
(
    id bigserial NOT NULL,
    data_hora timestamp,
    id_post bigserial,
    id_ej bigserial,
    status text DEFAULT 'ATIVO',
    PRIMARY KEY (id)
);

ALTER TABLE public.proposta
    ADD FOREIGN KEY (id_post)
    REFERENCES public.post (id)
    NOT VALID;
  
ALTER TABLE public.proposta
    ADD FOREIGN KEY (id_ej)
    REFERENCES public.usuario (id)
    NOT VALID;