BEGIN;

CREATE TABLE public.papel
(
    id bigserial NOT NULL,
    nome text,
    PRIMARY KEY (id)
);

CREATE TABLE public.usuario_papel
(
    id_usuario bigint NOT NULL,
    id_papel bigint NOT NULL
);

ALTER TABLE public.usuario_papel
    ADD FOREIGN KEY (id_usuario)
    REFERENCES public.usuario (id)
    NOT VALID;


ALTER TABLE public.usuario_papel
    ADD FOREIGN KEY (id_papel)
    REFERENCES public.papel (id)
    NOT VALID;

END;