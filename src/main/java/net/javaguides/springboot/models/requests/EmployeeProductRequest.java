package net.javaguides.springboot.models.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class EmployeeProductRequest {

    private Long orderHistoryId;
    private Integer amount;
}
