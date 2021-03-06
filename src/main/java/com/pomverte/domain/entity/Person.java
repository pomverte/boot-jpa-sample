package com.pomverte.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@SuppressWarnings("serial")
@Entity
@Table(name = "person")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "group_person_id", referencedColumnName = "id")
    private GroupPerson groupPerson;

    @NotNull
    @Column
    private String name;

    @NotNull
    @Column
    private String gender;

    @Temporal(TemporalType.DATE)
    @Column
    private Date birthdate;

    @NotNull
    @Column
    private Long rank;

}
