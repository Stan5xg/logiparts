package com.carbontec.logiparts.jpa.entities;

import javax.persistence.*;

@Entity
public class Compartment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne
    private Location location;
}
