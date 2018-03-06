package br.com.cemim.salesreport.processor;

import java.util.Map;

import br.com.cemim.salesreport.business.Customer;
import br.com.cemim.salesreport.business.FileReport;
import br.com.cemim.salesreport.business.GeneralReport;
import br.com.cemim.salesreport.business.Sale;
import br.com.cemim.salesreport.business.Salesman;
import br.com.cemim.salesreport.layout.CustomerLayout;
import br.com.cemim.salesreport.layout.SaleLayout;
import br.com.cemim.salesreport.layout.SalesmanLayout;

public class LineProcessor {

	private SalesmanLayout salesmanLayout;
	private CustomerLayout customerLayout;
	private SaleLayout saleLayout;

	private Map<Integer, Sale> saleMap;
	private Map<String, Customer> customerMap;
	private Map<String, Salesman> salesmanMap;
	private GeneralReport generalReport;
	private FileReport fileReport;

	public LineProcessor(
			SalesmanLayout salesmanLayout,
			CustomerLayout customerLayout,
			SaleLayout saleLayout,
			Map<String, Salesman> salesmanMap,
			Map<String, Customer> customerMap,
			Map<Integer, Sale> saleMap,
			GeneralReport generalReport,
			FileReport fileReport
		) {
		this.salesmanLayout = salesmanLayout;
		this.customerLayout = customerLayout;
		this.saleLayout = saleLayout;
		this.salesmanMap = salesmanMap;
		this.customerMap = customerMap;
		this.saleMap = saleMap;
		this.generalReport = generalReport;
		this.fileReport = fileReport;
	}

	public void analyze(String line) {
		
		switch (line.substring(0, 3)) {

			case SalesmanLayout.LAYOUT_CODE:
				
				Salesman salesman = salesmanLayout.read(line);
				if (!salesmanMap.containsKey(salesman.getName())) {
					salesmanMap.put(salesman.getName(), salesman);
				}
				fileReport.incrementAmountSalesman();
				break;
		
			case CustomerLayout.LAYOUT_CODE:
				
				Customer customer = customerLayout.read(line);
				if (!customerMap.containsKey(customer.getName()) ) {
					customerMap.put(customer.getName(), customer);
				}
				fileReport.incrementAmountClients();
				break;
		
			case SaleLayout.LAYOUT_CODE:
				
				Sale sale = saleLayout.read(line);
				if (generalReport.getMostExpensiveSale() == null) {
					generalReport.setMostExpensiveSale(sale);
				}
				if (sale.getTotal() > generalReport.getMostExpensiveSale().getTotal()) {
					generalReport.setMostExpensiveSale(sale);
				}
				Salesman saleSalesman = sale.getSalesman(); 
				saleSalesman.addSale(sale.getTotal());;
				saleMap.put(sale.getId(), sale);
				break;
		}
	}
}
