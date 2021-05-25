package net.javaguides.springboot.models.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class EmployeeRequest {

    @NotNull
    private Long id;
    private String name;
    private String surname;
    private String email;

}

