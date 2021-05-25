package net.javaguides.springboot.models.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.javaguides.springboot.models.audits.AuditModel;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@ApiModel(description = "City table")
@Data
@Entity
@Component
@Builder
@Table(name = "cities")
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
        name = "seq",
        sequenceName = "s_cities",
        initialValue = 1,
        allocationSize = 1)
public class City extends AuditModel {

    public static final String KAZAKHSTAN = "Kazakhstan";


    @Column(name="name")
    private String name;

    @Column(name="code")
    private String code;


}
