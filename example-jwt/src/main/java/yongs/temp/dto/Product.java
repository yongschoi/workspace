package yongs.temp.dto;

import java.util.List;

public class Product {
	private String category;
	private String name;
	private String color;
	private int cost;
	private boolean domestic;
	private List<String> version;
	
	public Product() {}
	public Product(String category, String name, String color, int cost, boolean domestic) {
		this(category, name, color, cost, domestic, null); 
	}
	
	public Product(String category, String name, String color, int cost, boolean domestic, List<String> version) {
		super();
		this.category = category;
		this.name = name;
		this.color = color;
		this.cost = cost;
		this.domestic = domestic;
		this.version = version; 
	}
 
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public boolean isDomestic() {
		return domestic;
	}

	public void setDomestic(boolean domestic) {
		this.domestic = domestic;
	}

	public List<String> getVersion() {
		return version;
	}

	public void setVersion(List<String> version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Product [category=" + category + ", name=" + name + ", color=" + color + ", cost=" + cost
				+ ", domestic=" + domestic + "]";
	}
}
