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


@Entity(name="film")
@Table(name="film")
public class FilmBean {
	
	@GeneratedValue
	@Id
	@Column(name="film_id")
	private int film_id;
	@Column(name="title")
	private String title;
	@Column(name="description")
	private String description;
	@Column(name="release_year")
	private String release_year;
	
	
	@ManyToMany
	@JoinTable(name = "film_actor", joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id")
	, inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id"))
	private List<AttoriBean> attoreList;
	
	
	@ManyToMany
	@JoinTable(name = "film_category", joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id")
	, inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"))
	private List<CategoryBean> categoryList;
	
	public List<CategoryBean> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<CategoryBean> categoryList) {
		this.categoryList = categoryList;
	}
	public List<AttoriBean> getAttoreList() {
		return attoreList;
	}
	public void setAttoreList(List<AttoriBean> attoreList) {
		this.attoreList = attoreList;
	}
	public int getFilm_id() {
		return film_id;
	}
	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRelease_year() {
		return release_year;
	}
	public void setRelease_year(String release_year) {
		this.release_year = release_year;
	}
	
	
}
