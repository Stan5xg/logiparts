package com.carbontec.logiparts.jpa.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne
    private Location location;

    @OneToMany(mappedBy="department")
    private Collection<User> users;
}
