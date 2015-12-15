package com.pomverte.service;

import java.util.List;

import com.pomverte.dto.PersonDto;

public interface PersonService {

    List<PersonDto> findByRank(Long rank);

    long sumElderRank(Long fromRank);
}
