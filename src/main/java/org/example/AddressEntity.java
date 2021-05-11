package org.example;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "address")
@Data
public class AddressEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addr_id;
    @Column
    private String city;
    @Column
    private String state;
    @OneToOne(mappedBy = "address")
    EmployeeEntity employee;

}
