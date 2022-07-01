package com.cdw.store.repo.specs;

import com.cdw.store.model.Attribute;
import com.cdw.store.model.Filter;
import com.cdw.store.model.Product;
import com.cdw.store.model.QueryOperator;
import org.hibernate.Session;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;


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



//        Subquery<Product> subP = query.subquery(Product.class);
//        Root<Product> rootP = subP.from(Product.class);
//
//        Subquery<Attribute> subAttribute = query.subquery(Attribute.class);
//        Root<Attribute> rootAttribute = subAttribute.from(Attribute.class);
//        Path<String> namePath =rootAttribute.get("name");
//        Path<String> valuePath=rootAttribute.get("value");
//
//        Predicate p1=builder.or(
//                builder.and(builder.equal(namePath,"THƯƠNG HIỆU"),
//                        builder.equal(valuePath,"Acer")
//
//                ),
//                builder.and(builder.equal(namePath,"THƯƠNG HIỆU"),
//                        builder.equal(valuePath,"Dell")
//
//                )
//        );
//        subAttribute.where(p1);
//
//
//        List<Predicate> predicates = new ArrayList<>();
//        List<Predicate> predicateNames= new ArrayList<>();
//        Join join = root.join("attributes");
//        Join joinCategory=join.join("category");
//        //add add criteria to predicates
//        for (Filter criteria : list) {
//
//            switch (criteria.getOperator()){
//                case GREATER_THAN:
//                    predicates.add(builder.greaterThan(
//                            root.get(criteria.getKey()), criteria.getValue().toString()));
//                    break;
//                case LESS_THAN:
//                    predicates.add(builder.lessThan(
//                            root.get(criteria.getKey()), criteria.getValue().toString()));
//                    break;
//                case GREATER_THAN_EQUAL:
//                    predicates.add(builder.greaterThanOrEqualTo(
//                            root.get(criteria.getKey()), criteria.getValue().toString()));
//                    break;
//                case LESS_THAN_EQUAL:
//                    predicates.add(builder.lessThanOrEqualTo(
//                            root.get(criteria.getKey()), criteria.getValue().toString()));
//                    break;
//                case NOT_EQUAL:
//                    predicates.add(builder.notEqual(
//                            root.get(criteria.getKey()), criteria.getValue()));
//                    break;
//                case EQUAL:

//                    if(criteria.getKey().startsWith("category")){
//                        System.out.println("58: "+criteria.getKey()+" = "+criteria.getValue());
//                        predicateOrAttributes.add(builder.equal(
//                                joinCategory.get(criteria.getKey().split("_")[1]), criteria.getValue()));
//                        break;
//                    }

//                    List<Predicate> predicateOrAttributes = new ArrayList<>();
//                    if(criteria.getValue() instanceof List){
//                        System.out.println("65: "+criteria.getKey()+" = "+criteria.getValue());
//                      ((List<?>) criteria.getValue()).forEach(System.out::println);
//                        IntStream.range(0, ((List<?>)criteria.getValue()).size())
//									.forEach(index -> {
//										Object value=((List<?>)criteria.getValue()).get(index);
//                                        predicateOrAttributes.add(builder.equal(
//                                                join.get(criteria.getKey()), value));
//
//									});
//
//
//                    }else{
//                        System.out.println("77: "+criteria.getKey()+" = "+criteria.getValue());
//                        predicateNames.add(builder.equal(
//                                join.get(criteria.getKey()), criteria.getValue()));
//                        break;
//                    }
//                    Predicate predicateValueOrValue= builder.or(predicateOrAttributes.toArray(new Predicate[0]));
//                    Predicate predicateName= builder.or(predicateNames.toArray(new Predicate[0]));
//                    Predicate predicateNameAndValue= builder.and(predicateName,predicateValueOrValue);
//                    predicates.add(predicateNameAndValue);
//                    predicateNames.clear();
//                    break;
//                case MATCH:
//                    predicates.add(builder.like(
//                            builder.lower(root.get(criteria.getKey())),
//                            "%" + criteria.getValue().toString().toLowerCase() + "%"));
//                    break;
//                case MATCH_END:
//                    predicates.add(builder.like(
//                            builder.lower(root.get(criteria.getKey())),
//                            criteria.getValue().toString().toLowerCase() + "%"));
//                    break;
//                case MATCH_START:
//                    predicates.add(builder.like(
//                            builder.lower(root.get(criteria.getKey())),
//                            "%" + criteria.getValue().toString().toLowerCase()));
//                    break;
//                case IN:
//                    predicates.add(builder.in(root.get(criteria.getKey())).value(criteria.getValue()));
//                    break;
//                case NOT_IN:
//                    predicates.add(builder.not(root.get(criteria.getKey())).in(criteria.getValue()));
//                    break;
//                default:
//                    throw new RuntimeException("Operation not supported yet");

//        }}
//        query.distinct(true);

//        Predicate predicateSector = builder.or(predicates.toArray(new Predicate[0]));
//        return builder.and(predicates.toArray(new Predicate[0]));






        Subquery<Attribute> subAttribute = query.subquery(Attribute.class);
        Root<Attribute> rootAttribute = subAttribute.from(Attribute.class);

        Subquery<Attribute> subAttribute2 = query.subquery(Attribute.class);
        Root<Attribute> rootAttribute2 = subAttribute.from(Attribute.class);

        Join<Object, Object> a1Join = root.join( "attributes" );
        Join<Object, Object> a2Join = root.join( "attributes" );
        Join<Object, Object> a3Join = root.join( "attributes" );
        Join<Object, Object> a4Join = root.join( "attributes" );

//        subAttribute.select(rootAttribute.get("id")).where(
//                builder.or(
//                        builder.and(
//                                builder.equal( rootAttribute.get( "name" ), "THƯƠNG HIỆU" ),
//                                builder.equal( rootAttribute.get( "value" ), "Dell" )
//                        )
//                        ,
//                        builder.and(
//                                builder.equal( rootAttribute.get( "name" ), "THƯƠNG HIỆU" ),
//                                builder.equal( rootAttribute.get( "value" ), "Gigabyte" )
//                        )
//                )
//        );
//        subAttribute2.select(rootAttribute2.get("id")).where(
//                builder.or(
//                        builder.and(
//                                builder.equal( rootAttribute2.get( "name" ), "NHU CẦU" ),
//                                builder.equal( rootAttribute2.get( "value" ), "Mỏng nhẹl" )
//                        )
//
//                )
//        );
//        Predicate predicate11 =a1Join.get("id").in( subAttribute);
//        Predicate predicate12 =a2Join.get("id").in( subAttribute2);

//        List<Predicate> predicates = new ArrayList<>();
//        Predicate v1 =builder.equal( a1Join.get("id"),a2Join.get("id"));
//        predicates.add(predicate11);
//        predicates.add(predicate12);
//        predicates.add(v1);
//        query.distinct(true);
//
//        Predicate predicateRR =root.in(predicates);
        Predicate predicate = builder.and(
                a1Join.get( "id" ).in( builder.or(
                        builder.and(
                                builder.equal( a1Join.get( "name" ), "THƯƠNG HIỆU" ),
                                builder.equal( a1Join.get( "value" ), "Dell" )
                        )
                        ,
                        builder.and(
                                builder.equal( a2Join.get( "name" ), "THƯƠNG HIỆU" ),
                                builder.equal( a2Join.get( "value" ), "Gigabyte" )
                        )
                )),
                a2Join.get( "id" ).in(builder.or(
                        builder.and(
                                builder.equal( rootAttribute2.get( "name" ), "NHU CẦU" ),
                                builder.equal( rootAttribute2.get( "value" ), "Mỏng nhẹl" )
                        )

                ))
        );
//        return builder.and(predicates.toArray(new Predicate[0]));
        return predicate;
    }

}
