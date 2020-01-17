package com.carbontec.logiparts.jpa.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "privileges")
    @ToString.Exclude
    private Collection<Role> roles;
}
