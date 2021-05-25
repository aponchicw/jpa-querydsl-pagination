package net.javaguides.springboot.models.requests;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CityRequest {
    private String name;
    private String code;
}
