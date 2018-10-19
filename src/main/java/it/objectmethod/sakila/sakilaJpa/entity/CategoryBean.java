package it.objectmethod.sakila.sakilaJpa.entity;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity(name="category")
@Table(name="category")
public class CategoryBean {
	@GeneratedValue
	@Id
	@Column(name="category_id")
	
	private int categoryId;
	
	@Column(name="Name")
	private String name;
	
	@ManyToMany
	@JoinTable(name = "film_category", joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id")
	, inverseJoinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"))
	private List<FilmBean> filmList;
	
	public List<FilmBean> getFilmList() {
		return filmList;
	}

	public void setFilmList(List<FilmBean> filmList) {
		this.filmList = filmList;
	}

	public int getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
