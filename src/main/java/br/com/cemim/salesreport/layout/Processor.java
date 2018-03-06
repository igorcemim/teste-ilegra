package br.com.cemim.salesreport.layout;

import java.util.HashMap;
import java.util.Map;

import br.com.cemim.salesreport.business.Customer;
import br.com.cemim.salesreport.business.FileReport;
import br.com.cemim.salesreport.business.GeneralReport;
import br.com.cemim.salesreport.business.Sale;
import br.com.cemim.salesreport.business.Salesman;

public class Processor {
	
	private SalesmanLayout salesmanLayout;
	private CustomerLayout customerLayout;
	private SaleLayout saleLayout;
	
	private Map<Integer, Sale> saleMap;
	private Map<String, Customer> customerMap;
	private Map<String, Salesman> salesmanMap;
		
	public Processor(
			SalesmanLayout salesmanLayout,
			CustomerLayout customerLayout,
			SaleLayout saleLayout,
			Map<String, Salesman> salesmanMap,
			Map<String, Customer> customerMap,
			Map<Integer, Sale> saleMap,
			GeneralReport report
		) {
		this.salesmanLayout = salesmanLayout;
		this.customerLayout = customerLayout;
		this.saleLayout = saleLayout;
		this.salesmanMap = salesmanMap;
		this.customerMap = customerMap;
		this.saleMap = saleMap;
	}

	public FileReport process(String[] lines) {
		FileReport fileReport = new FileReport();
		saleLayout.setSalesmanMap(salesmanMap);
		
		for (String line : lines) {
			switch (line.substring(0, 3)) {

				case SalesmanLayout.LAYOUT_CODE:
					Salesman salesman = salesmanLayout.read(line);
					if (!salesmanMap.containsKey(salesman.getName())) {
						salesmanMap.put(salesman.getName(), salesman);
					}
					break;

				case CustomerLayout.LAYOUT_CODE:
					Customer customer = customerLayout.read(line);
					if (!customerMap.containsKey(customer.getName()) ) {
						customerMap.put(customer.getName(), customer);
					}
					break;

				case SaleLayout.LAYOUT_CODE:
					Sale sale = saleLayout.read(line);
					saleMap.put(sale.getId(), sale);
					sale.getSalesman().addSale(sale.getTotal());;
					break;
			}
		}
		
		return fileReport;
	}

}
