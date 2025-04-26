package com.api_market.api.specification;

import com.api_market.api.DTO.ItemFilter;
import com.api_market.api.DTO.PersonagemFilter;
import com.api_market.api.Model.Personagem;
import org.springframework.data.jpa.domain.Specification;


import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.criteria.Predicate;

public class personagemSpecification {
    public static Specification<Personagem> withFilter(PersonagemFilter filter) { // <-- Corrige o tipo aqui
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.nome() != null) {
                predicates.add(cb.like(cb.lower(root.get("nome")), "%" + filter.nome().toLowerCase() + "%"));
            }

            if (filter.classe() != null) {
                predicates.add(cb.equal(root.get("classe"), filter.classe()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
