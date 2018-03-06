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
		String report = 
				"ID of the most expensive sale: " + mostExpensiveSale.getId() + "\n" +
				"Worst salesman ever: " + worstSalesman.getName() + "\n\n";

		return report;
	}

}
