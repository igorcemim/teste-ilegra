package br.com.cemim.salesreport.business;

public class Item implements Business {
	
	private int id;
	private int quantity;
	private double price;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", quantity=" + quantity + ", price=" + price + "]";
	}

}
