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

@Entity(name="actor")
@Table(name="actor")
public class AttoriBean {
	@GeneratedValue
	@Id
	@Column(name="actor_id")
	private int actorId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	
	@ManyToMany
	@JoinTable(name = "film_actor", joinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id")
	, inverseJoinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"))
	private List<FilmBean> filmList;
	
	public List<FilmBean> getFilmList() {
		return filmList;
	}
	public void setFilmList(List<FilmBean> filmList) {
		this.filmList = filmList;
	}
	public int getActorId() {
		return actorId;
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}