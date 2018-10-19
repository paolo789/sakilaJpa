package it.objectmethod.sakila.sakilaJpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.objectmethod.sakila.sakilaJpa.entity.AttoriBean;

@Repository
public interface AttoriRepository extends JpaRepository<AttoriBean, Integer> {
	public List<AttoriBean> findByLastNameContaining(String actor);
	
	/*@Query(value="select a.actor_id,a.first_name,a.last_name, fa.film_id from film_actor fa inner join actor a on fa.actor_id=a.actor_id where fa.film_id=?1",nativeQuery=true)
	public List<AttoriBean> getActorsByFilm(String film);*/

}