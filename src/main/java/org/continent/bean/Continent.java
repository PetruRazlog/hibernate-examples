package org.continent.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "continents")
@Data
@NoArgsConstructor
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int continent_id;
    @Column
    private String continent_name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "continent_id")
    private Set<Country> countries;

    public Continent(String continent_name) {
        this.continent_name = continent_name;
    }
}
