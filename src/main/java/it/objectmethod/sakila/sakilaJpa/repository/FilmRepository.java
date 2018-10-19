package it.objectmethod.sakila.sakilaJpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import it.objectmethod.sakila.sakilaJpa.entity.FilmBean;



@Repository
public interface FilmRepository extends JpaRepository<FilmBean, Integer> {
	public List<FilmBean> findByTitleContaining(String film);
	
	/*@Query(value="select f.film_id,f.title,f.description, f.release_year from film_actor fa inner join film f on fa.film_id=f.film_id where fa.actor_id=?1",nativeQuery=true)
	List<FilmBean >getFilmByActor(String attore); */
	
	@Query(value="select f.film_id,f.title,f.description,f.release_year from film f inner join film_category fc on f.film_id=fc.film_id where fc.category_id=?1",nativeQuery=true)
	public List<FilmBean> getFilmByCategory(String filmGenere);
}
