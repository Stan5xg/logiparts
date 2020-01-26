package com.carbontec.logiparts.jpa.entities;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.LinkedList;
import java.util.List;

@Data
@Entity
public class Part {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private PartType partType;

    @OneToMany
    @JoinColumn
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Part> parts = new LinkedList<>();

    @ManyToOne
    private Location location;

    private String serialNum;

    @Column(nullable = false)
    private Boolean isRoot = false;
}
