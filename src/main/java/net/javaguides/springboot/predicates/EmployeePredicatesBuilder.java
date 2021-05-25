package net.javaguides.springboot.predicates;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class EmployeePredicatesBuilder {
    private List<SearchCriteria> params;

    public EmployeePredicatesBuilder() {
        params = new ArrayList<>();
    }
    public EmployeePredicatesBuilder with(
            String key, String operation, Object value) {


        params.add(new SearchCriteria(key, operation, value));
        return this;
    }


    public SearchCriteria has(String key) {
        for (SearchCriteria param : params) {
            if (param.getKey().equals(key)){
                return param;
            }
            else {
                return null;
            }
        }
        return null;
    }


    public BooleanExpression build() {
        if (params.size() == 0) {
            return null;
        }

        List<BooleanExpression> predicates = params.stream().map(param -> {
            EmployeePredicate predicate = new EmployeePredicate(param);
            return predicate.getPredicate();
        }).filter(Objects::nonNull).collect(Collectors.toList());
        BooleanExpression result = Expressions.asBoolean(true).isTrue();
        for (BooleanExpression predicate : predicates) {
            result = result.and(predicate);
        }
        return result;
    }
}