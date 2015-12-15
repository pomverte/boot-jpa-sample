package com.pomverte.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.pomverte.domain.entity.Person;

/**
 * WARN custom behaviour must be named as follow :
 * <code>[JpaRepository Interface name][Impl]</code>
 * 
 * @author hvle
 *
 */
@Repository
public class PersonRepositoryImpl implements PersonRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Person> findByGroupName(String groupName) {
        return this.em
                .createQuery("SELECT p FROM Person p JOIN p.groupPerson gp WHERE gp.name = :groupName", Person.class)
                .setParameter("groupName", groupName).getResultList();
    }

}
