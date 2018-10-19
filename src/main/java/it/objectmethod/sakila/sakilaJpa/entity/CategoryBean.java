package it.objectmethod.sakila.sakilaJpa.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
