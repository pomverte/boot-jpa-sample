package com.pomverte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pomverte.dto.PersonDto;
import com.pomverte.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/findByRank/{rank}", method = RequestMethod.GET)
    List<PersonDto> findByRank(@PathVariable Long rank) {
        return this.personService.findByRank(rank);
    }

}
