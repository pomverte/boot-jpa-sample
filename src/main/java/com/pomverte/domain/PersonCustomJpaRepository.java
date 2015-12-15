package com.pomverte.domain;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.repository.Repository;

import com.pomverte.domain.entity.Person;

public class PersonCustomJpaRepository implements PersonCustomRepository, Repository<Person, Long> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public int sumElderRank(Long fromRank) {
        Query query = this.entityManager.createQuery("SELECT SUM(*) FROM Person p WHERE p.rank > ?1");
        query.setParameter(1, fromRank);
        return (Integer) query.getSingleResult();
	}

}
