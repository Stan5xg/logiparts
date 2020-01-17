package com.carbontec.logiparts.jpa.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Collection;

@Data
@Entity
@ToString
public class Department {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne
    @ToString.Exclude
    private Location location;

    @OneToMany(mappedBy="department")
    @ToString.Exclude
    private Collection<User> users;
}
