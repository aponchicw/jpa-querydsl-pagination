package net.javaguides.springboot.methods;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.models.requests.EmployeeRequest;
import net.javaguides.springboot.services.employees.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CallApi {

//    public List<EmployeeRequest> getEmployeeList (List<Long> employeeIds){
//        try{
//            ResponseEntity<List<EmployeeRequest>> responseEntity = employeeService.findByIds(employeeIds);
//            return responseEntity.getBody();
//        }catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }
}