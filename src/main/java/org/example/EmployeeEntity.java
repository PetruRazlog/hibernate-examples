package org.example;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employee")
@Data
public class EmployeeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer emp_id;
    @Column(unique = true, length = 30)
    private String fname;
    @Column
    private String lname;
    @Column
    private String email;
    @Column(columnDefinition = "int(10) default 18")
    private int age;
    @OneToOne
    AddressEntity address;


}
