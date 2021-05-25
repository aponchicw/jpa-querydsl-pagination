package net.javaguides.springboot.services.employees;

import net.javaguides.springboot.models.entities.Employee;
import net.javaguides.springboot.models.requests.CityRequest;
import net.javaguides.springboot.models.requests.EmployeeRequest;
import net.javaguides.springboot.models.responses.paginator.PageResponse;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    PageResponse getAll(Optional<String> search,
                        Optional<Integer> page,
                        Optional<Integer> size,
                        Optional<String[]> sortBy);

    PageResponse getEmployeesPaginated(Optional<Integer> page,
                                     Optional<Integer> size,
                                     Optional<String[]> sortBy);

    PageResponse getModuleEmployeesPaginated(Optional<Integer> page,
                                           Optional<Integer> size,
                                           Optional<String[]> sortBy,
                                           Optional<String> search,
                                           Long employeeId);

    Employee moduleEmployee(EmployeeRequest EmployeeRequest, Long employeeId);

    Employee moduleOnlineEmployee(EmployeeRequest EmployeeRequest, Long employeeId);

    List<Employee> findByIds(List<Long> ids);

    List<Employee> findByEmployeeId(Long employeeId);

    void saveAll(List<Employee> employees);

    void addCity(CityRequest cityRequest);

    Integer sumAll();
}
