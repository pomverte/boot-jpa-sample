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
    public ResponseEntity<List<PersonDto>> findByRank(@PathVariable long rank) {
            return new ResponseEntity<List<PersonDto>>(this.personService.findByRank(rank), HttpStatus.OK);
    }

    @RequestMapping(value = "/sumElderRank/{fromRank}", method = RequestMethod.GET)
    public ResponseEntity<Long> sumElderRank(@PathVariable Long fromRank) {
        return new ResponseEntity<Long>(this.personService.sumElderRank(fromRank), HttpStatus.OK);
    }

    @RequestMapping(value = "/findByGroupName/{groupName}", method = RequestMethod.GET)
    public ResponseEntity<List<PersonDto>> findByGroupName(@PathVariable String groupName) {
        return new ResponseEntity<List<PersonDto>>(this.personService.findByGroupName(groupName), HttpStatus.OK);
    }

}
