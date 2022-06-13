package com.cdw.store.repo.specs;

import com.cdw.store.model.Attribute;
import com.cdw.store.model.Filter;
import com.cdw.store.model.Product;
import com.cdw.store.model.QueryOperator;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class ProductSpecification implements Specification<Product> {
    private List<Filter> list;

    public ProductSpecification() {
        this.list = new ArrayList<>();
    }

    public void add(Filter criteria) {
        list.add(criteria);
    }

    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        List<Predicate> predicates = new ArrayList<>();

        Join join = root.join("attributes");

        //add add criteria to predicates
        for (Filter criteria : list) {
            switch (criteria.getOperator()){
                case GREATER_THAN:
                    predicates.add(builder.greaterThan(
                            root.get(criteria.getKey()), criteria.getValue().toString()));
                    break;
                case LESS_THAN:
                    predicates.add(builder.lessThan(
                            root.get(criteria.getKey()), criteria.getValue().toString()));
                    break;
                case GREATER_THAN_EQUAL:
                    predicates.add(builder.greaterThanOrEqualTo(
                            root.get(criteria.getKey()), criteria.getValue().toString()));
                    break;
                case LESS_THAN_EQUAL:
                    predicates.add(builder.lessThanOrEqualTo(
                            root.get(criteria.getKey()), criteria.getValue().toString()));
                    break;
                case NOT_EQUAL:
                    predicates.add(builder.notEqual(
                            root.get(criteria.getKey()), criteria.getValue()));
                    break;
                case EQUAL:
                    if(criteria.getKey().startsWith("category")){
                        join=join.join("category");
                        predicates.add(builder.equal(
                                join.get(criteria.getKey().split("_")[1]), criteria.getValue()));
                        break;
                    }
                    predicates.add(builder.equal(
                            join.get(criteria.getKey()), criteria.getValue()));
                    break;
                case MATCH:
                    predicates.add(builder.like(
                            builder.lower(root.get(criteria.getKey())),
                            "%" + criteria.getValue().toString().toLowerCase() + "%"));
                    break;
                case MATCH_END:
                    predicates.add(builder.like(
                            builder.lower(root.get(criteria.getKey())),
                            criteria.getValue().toString().toLowerCase() + "%"));
                    break;
                case MATCH_START:
                    predicates.add(builder.like(
                            builder.lower(root.get(criteria.getKey())),
                            "%" + criteria.getValue().toString().toLowerCase()));
                    break;
                case IN:
                    predicates.add(builder.in(root.get(criteria.getKey())).value(criteria.getValue()));
                    break;
                case NOT_IN:
                    predicates.add(builder.not(root.get(criteria.getKey())).in(criteria.getValue()));
                    break;
                default:
                    return null;

        }}

        return builder.and(predicates.toArray(new Predicate[0]));
    }

}