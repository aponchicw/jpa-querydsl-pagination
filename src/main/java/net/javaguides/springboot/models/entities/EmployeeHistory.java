//package net.javaguides.springboot.models.entities;
//
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import net.javaguides.springboot.models.audits.AuditModel;
//
//import javax.persistence.*;
//
//@Data
//@Entity
//@Table(name = "refund_products")
//@SequenceGenerator(
//        name = "seq",
//        sequenceName = "s_refund_history",
//        initialValue = 1,
//        allocationSize = 1
//)
//@AllArgsConstructor
//@NoArgsConstructor
//@ApiModel(description = "Employees table")
//public class EmployeeHistory extends AuditModel {
//
//    @Column(name = "id")
//    @ApiModelProperty(notes = "Id of Employee")
//    private Long id;
//
//    @Column(name = "first_name")
//    @ApiModelProperty(notes = "Name")
//    private String name;
//
//    @Column(name = "last_name")
//    @ApiModelProperty(notes = "Surname")
//    private String surname;
//
//    @Column(name = "email")
//    @ApiModelProperty(notes = "Surname")
//    private String email;
//}