package com.carbontec.logiparts.jpa.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Data
@Entity
@ToString
public class History {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private Location locationFrom;

    @OneToOne
    private Location locationTo;

    private Date date;

    @OneToOne
    private User user;
}
