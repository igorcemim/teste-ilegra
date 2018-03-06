package br.com.cemim.salesreport.business;

public class GeneralReport {
	
	private Salesman worstSalesman;
	
	private Sale mostExpensiveSale;

	public Salesman getWorstSalesman() {
		return worstSalesman;
	}

	public void setWorstSalesman(Salesman worstSalesman) {
		this.worstSalesman = worstSalesman;
	}

	public Sale getMostExpensiveSale() {
		return mostExpensiveSale;
	}

	public void setMostExpensiveSale(Sale mostExpensiveSale) {
		this.mostExpensiveSale = mostExpensiveSale;
	}

	@Override
	public String toString() {
		return "GeneralReport [worstSalesman=" + worstSalesman + ", mostExpensiveSale=" + mostExpensiveSale + "]";
	}

}
