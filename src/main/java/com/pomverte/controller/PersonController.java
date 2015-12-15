package com.pomverte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<PersonDto>> findByRank(@PathVariable Long rank) {
        return new ResponseEntity<List<PersonDto>>(this.personService.findByRank(rank), HttpStatus.OK);
    }

}
