package com.pomverte.domain;

import java.util.List;

import com.pomverte.domain.entity.Person;

public interface PersonRepositoryCustom {

    List<Person> findByGroupName(String groupName);

    List<Person> findByGroupNameCriteria(String groupName);

}
