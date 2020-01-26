package com.carbontec.logiparts.jpa.entities;

import com.carbontec.logiparts.jpa.entities.parts.Part;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Data
@Entity
@ToString
public class Location {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String address;

    private String postalCode;

    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "location")
    private Collection<Part> part;
}
