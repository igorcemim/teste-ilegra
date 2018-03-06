package br.com.cemim.salesreport.business;

public class FileReport {
	
	private String file;
	
	private int amountClients;
	
	private int amountSalesman;
	
	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

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
		String report =
				"File: " + file + "\n" +
				"Amount of clients in the input file: " + amountClients + "\n" +
				"Amount of salesman in the input file: " + amountSalesman + "\n\n";
		
		return report;
	}

}
