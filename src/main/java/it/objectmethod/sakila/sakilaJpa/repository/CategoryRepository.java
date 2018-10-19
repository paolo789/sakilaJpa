package it.objectmethod.sakila.sakilaJpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.objectmethod.sakila.sakilaJpa.entity.CategoryBean;


@Repository
public interface CategoryRepository  extends JpaRepository<CategoryBean, String>{

	public List<CategoryBean> findAll();	
}
