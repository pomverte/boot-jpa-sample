package com.pomverte.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.pomverte.domain.PersonRepository;
import com.pomverte.dto.PersonDto;
import com.pomverte.utils.ListBeanUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class PersonDefaultService implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<PersonDto> findByRank(Long rank) {
        Assert.notNull(rank);
        try {
            return ListBeanUtils.copyProperties(this.personRepository.findByRank(rank), PersonDto.class);
        } catch (InstantiationException | IllegalAccessException e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public long sumElderRank(Long fromRank) {
        Assert.notNull(fromRank);
        return this.personRepository.sumElderRank(fromRank);
    }

    @Override
    public List<PersonDto> findByGroupName(String groupName) {
        Assert.notNull(groupName);
        try {
            return ListBeanUtils.copyProperties(this.personRepository.findByGroupName(groupName), PersonDto.class);
        } catch (InstantiationException | IllegalAccessException e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

}
