package com.carbontec.logiparts.jpa.entities.parts;

import com.carbontec.logiparts.jpa.entities.Location;
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
public class PartType {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @OneToMany
    @JoinColumn
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<PartType> partTypes = new LinkedList<>();

    @OneToMany(mappedBy = "partType")
    private List<Part> parts = new LinkedList<>();

    private String name;
    private String partNum;

    @Column(nullable = false)
    private Boolean isRoot = false;
}
