package com.pomverte.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDto {

    @JsonView
    private Long id;

    @JsonView
    private String name;

    @JsonView
    private String gender;

    @JsonView
    private Date birthdate;

    @JsonView
    private Long rank;
}
