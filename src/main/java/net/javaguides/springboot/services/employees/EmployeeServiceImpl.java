package net.javaguides.springboot.services.employees;

import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.AllArgsConstructor;
import net.javaguides.springboot.methods.Pagination;
import net.javaguides.springboot.models.entities.City;
import net.javaguides.springboot.models.entities.Employee;
import net.javaguides.springboot.models.requests.CityRequest;
import net.javaguides.springboot.models.requests.EmployeeRequest;
import net.javaguides.springboot.models.responses.employees.CityResponse;
import net.javaguides.springboot.models.responses.employees.EmployeeResponse;
import net.javaguides.springboot.models.responses.paginator.PageResponse;
import net.javaguides.springboot.predicates.EmployeePredicatesBuilder;
import net.javaguides.springboot.repositories.CityRepository;
import net.javaguides.springboot.repositories.EmployeeRepository;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private CityRepository cityRepository;

    private Pagination pagination;

    @Override
    public PageResponse getAll(Optional<String> search,
                               Optional<Integer> page,
                               Optional<Integer> size,
                               Optional<String[]> sortBy) {
        System.out.println("Che proishodit");
        EmployeePredicatesBuilder builder = new EmployeePredicatesBuilder();

        if (search.isPresent()) {
            Pattern pattern = Pattern.compile("(\\w+?[.]\\w+?|\\w+?)" +
                    "(:|<|>)" +
                    "(\\w+?\\s\\w+?|\\w+?|\\w+?\\s\\w+?\\s\\w+?|\\w+?[-]\\w+?[-]\\w+?\\w+?),", Pattern.UNICODE_CHARACTER_CLASS);
            Matcher matcher = pattern.matcher(search.get() + ",");
            while (matcher.find()) {
                builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
            }
        }
        BooleanExpression exp = builder.build();
        System.out.println("Check 1");
        Page<City> cities = cityRepository.findAll(exp, pagination.paginate(page, size, sortBy));
        System.out.println("CHECK 2 " + cities);
        return commonAll(cities, exp);
    }

    @Override
    public PageResponse getEmployeesPaginated(Optional<Integer> page, Optional<Integer> size, Optional<String[]> sortBy) {
        return null;
    }

    @Override
    public PageResponse getModuleEmployeesPaginated(Optional<Integer> page, Optional<Integer> size, Optional<String[]> sortBy, Optional<String> search, Long employeeId) {
        return null;
    }

    @Override
    public Employee moduleEmployee(EmployeeRequest EmployeeRequest, Long employeeId) {
        return null;
    }

    @Override
    public Employee moduleOnlineEmployee(EmployeeRequest EmployeeRequest, Long employeeId) {
        return null;
    }

    @Override
    public List<Employee> findByIds(List<Long> ids) {
        return null;
    }

    @Override
    public List<Employee> findByEmployeeId(Long employeeId) {
        return null;
    }

    @Override
    public void saveAll(List<Employee> employees) {

    }

    @Override
    public void addCity(CityRequest cityRequest) {
        City city = City.builder()
                .name(cityRequest.getName())
                .code(cityRequest.getCode())
                .build();
        cityRepository.save(city);
    }

    @Override
    public Integer sumAll() {
        return null;
    }

    private PageResponse commonAll(Page<City> cityPage, BooleanExpression exp) {
//        List<CityResponse> cityResponses = new ArrayList<>();
//        List<City> cities = cityPage.getContent();
//
//        cityResponses = cities.stream().map(e-> CityResponse.builder()
//        .id(e.getId())
//        .name(e.getName())
//        .code(e.getCode())
//        .build()).collect(Collectors.toList());
        return pagination.convertToEmployeeResponse(cityPage.getContent(), cityPage);
    }
}
