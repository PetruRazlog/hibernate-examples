package org.continent.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "countries")
@Data
@NoArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int country_id;
    @Column
    private String country_name;

    public Country(String country_name) {
        this.country_name = country_name;
    }
}
