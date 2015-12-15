package com.pomverte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pomverte.repository.entity.Person;

// http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.sample-app.finders.strategies
public interface PersonRepository extends JpaRepository<Person, Long> {

	List<Person> findByRank(Long rank);

	/**
     * Recherche des personne par rang et sexe. Note : l'annotation Param n'est
     * pas obligatoire, si non présent, Spring Data se basera sur le nom du
     * paramètre.
     *
     * <code>
     * select * from personne
     * where rank = ? and gender = ?
     * order by name
     * </code>
     */
	List<Person> findByRankAndGenderOrderByName(@Param("rank") Long rank, @Param("gender") String gender);

	@Query("select count(*) from #{#entityName} where rank = :rank")
	int countByRank(Long rank);

}
