package com.lizbaze.mealplan.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String description;
	
	@OneToMany(mappedBy="recipe")
	private List<Ingredient> ingredients;
	
	@OneToMany(mappedBy="recipe")
	private List<Instruction> instructions;
	
	public Recipe() {}

	

	public Recipe(int id, String name, String description, List<Ingredient> ingredients, List<Instruction> instructions) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.ingredients = ingredients;
		this.instructions = instructions;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public List<Ingredient> getIngredients() {
		return ingredients;
	}



	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}



	public List<Instruction> getInstructions() {
		return instructions;
	}



	public void setInstructions(List<Instruction> instructions) {
		this.instructions = instructions;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recipe other = (Recipe) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", description=" + description + ", ingredients=" + ingredients
				+ "]";
	}
	
	
}