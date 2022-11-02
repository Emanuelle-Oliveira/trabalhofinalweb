CREATE TABLE public.post
(
    id bigserial NOT NULL,
    descricao text,
    data_hora timestamp,
    categoria text,
    id_cliente bigserial,
    id_proposta_escolhida bigserial,
    status text DEFAULT 'ATIVO',
    PRIMARY KEY (id)
);

ALTER TABLE public.post
    ADD FOREIGN KEY (id_cliente)
    REFERENCES public.usuario (id)
    NOT VALID;