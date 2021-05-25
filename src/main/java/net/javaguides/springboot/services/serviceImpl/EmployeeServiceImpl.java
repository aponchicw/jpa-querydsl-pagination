//package net.javaguides.springboot.services.serviceImpl;
//
//import net.javaguides.springboot.models.entities.Employee;
//import net.javaguides.springboot.models.requests.EmployeeRequest;
//import net.javaguides.springboot.models.responses.paginator.PageResponse;
//import net.javaguides.springboot.repositories.EmployeeRepository;
//import net.javaguides.springboot.services.employees.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class EmployeeServiceImpl implements EmployeeService {
//    private EmployeeRepository employeeRepository;
//
//    @Autowired
//    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//
//
//    }
//
//    @Override
//    public PageResponse getAll(Optional<String> search, Optional<Integer> page, Optional<Integer> size, Optional<String[]> sortBy) {
//        return null;
//    }
//
//    @Override
//    public PageResponse getEmployeesPaginated(Optional<Integer> page, Optional<Integer> size, Optional<String[]> sortBy) {
//        return null;
//    }
//
//    @Override
//    public PageResponse getModuleEmployeesPaginated(Optional<Integer> page, Optional<Integer> size, Optional<String[]> sortBy, Optional<String> search, Long employeeId) {
//        return null;
//    }
//
//    @Override
//    public Employee moduleEmployee(EmployeeRequest EmployeeRequest, Long employeeId) {
//        return null;
//    }
//
//    @Override
//    public Employee moduleOnlineEmployee(EmployeeRequest EmployeeRequest, Long employeeId) {
//        return null;
//    }
//
//    @Override
//    public Integer sumAll() {
//        return null;
//    }
//}
