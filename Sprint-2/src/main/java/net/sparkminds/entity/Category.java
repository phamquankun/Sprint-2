package net.sparkminds.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.sparkminds.entity.enumeration.CategoryStatus;

@Entity
@Table(name="category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="status")
	private CategoryStatus status;
	
	@OneToMany(mappedBy = "category")
	private List<Image> images;
	
	public Category() {}
	
	public Category(long id, String name, String description, CategoryStatus status) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.status = status;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public CategoryStatus getStatus() {
		return status;
	}
	public void setStatus(CategoryStatus string) {
		this.status = string;
	}
}