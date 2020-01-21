package com.carbontec.logiparts.jpa.entities.parts;

import com.carbontec.logiparts.jpa.entities.Location;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private List<ParameterValue> parameterValues;

    @OneToMany
    private List<Part> parts = new LinkedList<>();

    @ManyToOne
    private Location location;

    private String serialNum;
}
