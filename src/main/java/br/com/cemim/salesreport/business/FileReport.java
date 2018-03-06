package br.com.cemim.salesreport.business;

public class FileReport {
	
	private String file;
	
	private int amountClients;
	
	private int amountSalesman;
	
	public void incrementAmountClients() {
		amountClients++;
	}
	
	public void incrementAmountSalesman() {
		amountSalesman++;
	}
	
	public int getAmountSalesman() {
		return amountSalesman;
	}
	
	public int getAmountClients() {
		return amountClients;
	}

	@Override
	public String toString() {
		return "FileReport [file=" + file + ", amountClients=" + amountClients + ", amountSalesman=" + amountSalesman
				+ "]";
	}

}
