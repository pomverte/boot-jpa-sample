package com.pomverte.domain;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

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
    public void toto() {
        // ma query
    }

}
