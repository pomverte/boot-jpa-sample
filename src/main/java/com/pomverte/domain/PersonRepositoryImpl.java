package com.pomverte.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

import org.springframework.stereotype.Repository;

import com.pomverte.domain.entity.GroupPerson;
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

    @Override
    public List<Person> findByGroupNameCriteria(String groupName) {
        CriteriaBuilder builder = this.em.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = builder.createQuery(Person.class);
        Join<Person, GroupPerson> groupPerson = criteriaQuery.from(Person.class).join("groupPerson", JoinType.INNER);
        criteriaQuery.where(builder.equal(groupPerson.get("name"), groupName));
        return this.em.createQuery(criteriaQuery).getResultList();
    }

}
