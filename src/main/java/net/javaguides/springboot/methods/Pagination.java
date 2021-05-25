package net.javaguides.springboot.methods;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.models.entities.City;
import net.javaguides.springboot.models.entities.Employee;
import net.javaguides.springboot.models.responses.employees.CityResponse;
import net.javaguides.springboot.models.responses.employees.EmployeeResponse;
import net.javaguides.springboot.models.responses.paginator.PageResponse;
import net.javaguides.springboot.models.responses.paginator.PageableResponse;
import net.javaguides.springboot.models.responses.paginator.SortResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class Pagination {

    public PageRequest paginate(Optional<Integer> page,
                                Optional<Integer> size,
                                Optional<String[]> sortBy) {
        Sort sort = Sort.by("id");
        if(sortBy.isPresent()){
            String[] sorters = sortBy.get();
            List<Sort.Order> sorts = Arrays.stream(sorters)
                    .map(s -> s.split("-")[0].trim().equalsIgnoreCase("asc")
                            ? Sort.Order.asc(s.split("-")[1]) : Sort.Order.desc(s.split("-")[1]))
                    .collect(Collectors.toList());
            sort = Sort.by(sorts);
        }
        return PageRequest.of(page.orElse(0),size.orElse(5),sort);
    }

    public List<EmployeeResponse> convertToEmployeeResponse(List<Employee> employee) {
        List<EmployeeResponse> employeeResponses = null;
        if (employee != null) {
            employeeResponses = employee.stream().map((e) -> EmployeeResponse.builder()
                    .id(e.getId())
                    .name(e.getFirstName())
                    .surname(e.getLastName())
                    .email(e.getEmail())
                    .build())
                    .collect(Collectors.toList());
        }
        return employeeResponses;
    }

    private PageResponse convertToPageResponse(List<?> responses, Page page) {
        SortResponse sortResponse = SortResponse.builder()
                .sorted(page.getSort().isSorted())
                .unsorted(page.getSort().isUnsorted())
                .empty(page.getSort().isEmpty())
                .build();

        PageableResponse pageableResponse = PageableResponse.builder()
                .sortResponse(sortResponse)
                .pageNumber(page.getPageable().getPageNumber())
                .pageSize(page.getPageable().getPageSize())
                .paged(page.getPageable().isPaged())
                .build();

        PageResponse pageResponse =
                PageResponse.builder()
                        .totalPages(page.getTotalPages())
                        .content(responses)
                        .last(page.isLast())
                        .first(page.isFirst())
                        .size(page.getSize())
                        .totalElements(page.getTotalElements())
                        .pageable(pageableResponse)
                        .numberOfElements(page.getNumberOfElements())
                        .build();
        return pageResponse;
    }

    public PageResponse convertToEmployeeResponse(List<City> cities, Page<?> page) {

        List<CityResponse> employeeResponses = cities.stream().map((e) -> CityResponse.builder()
                .id(e.getId())
                .name(e.getName())
                .code(e.getCode())
                .build())
                .collect(Collectors.toList());

        return convertToPageResponse(employeeResponses, page);
    }
}