package br.com.cemim.salesreport.business;

import java.util.List;

public class Sale implements Business {
	
	private int id;
	
	private Salesman salesman;
	
	private List<Item> items;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Salesman getSalesman() {
		return salesman;
	}

	public void setSalesman(Salesman salesman) {
		this.salesman = salesman;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Sale [id=" + id + ", salesman=" + salesman + ", items=" + items + "]";
	}

}
