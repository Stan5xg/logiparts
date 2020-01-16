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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Collection<Department> departments) {
        this.departments = departments;
    }

    public Collection<Compartment> getCompartments() {
        return compartments;
    }

    public void setCompartments(Collection<Compartment> compartments) {
        this.compartments = compartments;
    }
}
