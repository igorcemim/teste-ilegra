package br.com.cemim.salesreport.business;

public class Salesman {

	private String cpf;
	
	private String name;
		
	private double salary;
	
	private double sales;
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void addSale(double sale) {
		sales += sale;
	}
	
	public double getSales() {
		return sales;
	}

	@Override
	public String toString() {
		return "Salesman [cpf=" + cpf + ", name=" + name + ", salary=" + salary + ", sales=" + sales + "]";
	}

}
