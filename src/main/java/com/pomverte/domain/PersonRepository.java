package com.pomverte.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pomverte.domain.entity.Person;

// http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.sample-app.finders.strategies
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByRank(Long rank);

    /**
     * Recherche des personne par rang et sexe. Note : l'annotation Param n'est
     * pas obligatoire, si non présent, Spring Data se basera sur le nom du
     * paramètre.
     *
     * <code>SELECT * FROM personne WHERE rank = ? AND gender = ? ORDER BY NAME</code>
     */
    List<Person> findByRankAndGenderOrderByName(@Param("rank") Long rank, @Param("gender") String gender);

    long countByRank(Long rank);

    @Query("SELECT COALESCE(SUM(p.rank), 0) FROM Person p WHERE p.rank >= :fromRank")
    long sumElderRank(@Param("fromRank") Long fromRank);

}
