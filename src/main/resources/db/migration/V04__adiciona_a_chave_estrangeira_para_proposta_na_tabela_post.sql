ALTER TABLE public.post
    ADD FOREIGN KEY (id_proposta_escolhida)
    REFERENCES public.proposta(id)
    NOT VALID;