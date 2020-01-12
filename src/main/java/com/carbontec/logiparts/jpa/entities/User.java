package com.carbontec.logiparts.jpa.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String title;

    private String number;

    private String email;

    private String password;

    @ManyToOne
    private Department department;
}