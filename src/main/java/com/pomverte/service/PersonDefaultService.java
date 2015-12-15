package com.pomverte.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pomverte.domain.PersonRepository;
import com.pomverte.domain.entity.Person;
import com.pomverte.dto.PersonDto;

@Service
@Transactional
public class PersonDefaultService implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<PersonDto> findByRank(Long rank) {
        List<PersonDto> result = new ArrayList<>();
        List<Person> found = this.personRepository.findByRank(rank);
        for (Person source : found) {
            PersonDto target = new PersonDto();
            BeanUtils.copyProperties(source, target);
            result.add(target);
        }
        return result;
    }

}
