package net.javaguides.springboot.predicates;

import com.querydsl.core.types.dsl.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import net.javaguides.springboot.models.entities.City;
import net.javaguides.springboot.models.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static org.hibernate.query.criteria.internal.ValueHandlerFactory.isNumeric;

@Data
@AllArgsConstructor
public class EmployeePredicate {

    @Autowired
    private SearchCriteria criteria;

    public BooleanExpression getPredicate() {
        PathBuilder<City> entityPath = new PathBuilder<>(City.class, "city");
        String criteriaValue = criteria.getValue().toString();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = df.parse(criteriaValue);
        } catch (ParseException e) {
            date = null;
        }
        if (isNumeric(criteriaValue)) {
            NumberPath<Integer> path = entityPath.getNumber(criteria.getKey(), Integer.class);
            int value = Integer.parseInt(criteriaValue);
            switch (criteria.getOperation()) {
                case ":":
                    return path.eq(value);
                case ">":
                    return path.goe(value);
                case "<":
                    return path.loe(value);
            }
        }
        else if(date != null) {
            System.out.println("here date : " + date);
            DateTimePath<Date> path = entityPath.getDateTime(criteria.getKey(), Date.class);
            switch (criteria.getOperation()) {
                case ">":
                    return path.after(date);
                case "<":
                    return path.before(date);
                case ":":
                    return path.eq(date);

            }
        }
        else if(criteriaValue.equalsIgnoreCase("true")||criteriaValue.equalsIgnoreCase("false")){
            BooleanPath path = entityPath.getBoolean(criteria.getKey());
            if (criteria.getOperation().equalsIgnoreCase(":")) {
                return path.eq(Boolean.parseBoolean(criteriaValue));
            }
        }

        else {
            StringPath path = entityPath.getString(criteria.getKey());
            if (criteria.getOperation().equalsIgnoreCase(":")) {
                return path.containsIgnoreCase(criteriaValue);
            }
        }
        return null;
    }
}