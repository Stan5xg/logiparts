package com.carbontec.logiparts.jpa.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String address;

    private String postalCode;

    private String name;

    @OneToMany(mappedBy = "location")
    private Collection<Department> departments;

    @OneToMany(mappedBy = "location")
    private Collection<Compartment> compartments;
}
