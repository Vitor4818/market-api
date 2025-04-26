package com.api_market.api.specification;

import com.api_market.api.DTO.ItemFilter;
import com.api_market.api.Model.Item;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;


public class ItemSpecification {
    public static Specification<Item> withFilters(ItemFilter filter) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.nome() != null) {
                predicates.add(cb.like(cb.lower(root.get("nome")), "%" + filter.nome().toLowerCase() + "%"));
            }
            if (filter.tipo() != null) {
                predicates.add(cb.equal(root.get("tipo"), filter.tipo()));
            }
            if (filter.precoMin() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("preco"), filter.precoMin()));
            }
            if (filter.precoMax() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("preco"), filter.precoMax()));
            }
            if (filter.raridade() != null) {
                predicates.add(cb.equal(root.get("raridade"), filter.raridade()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
