package com.pomverte.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PersonDto {

    private Long id;

    private String name;

    private String gender;

    private Date birthdate;

    private Long rank;

}
