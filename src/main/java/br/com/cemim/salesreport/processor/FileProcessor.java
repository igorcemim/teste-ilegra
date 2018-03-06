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

public class FileProcessor {
	
	private SalesmanLayout salesmanLayout;
	private CustomerLayout customerLayout;
	private SaleLayout saleLayout;
	
	private Map<Integer, Sale> saleMap;
	private Map<String, Customer> customerMap;
	private Map<String, Salesman> salesmanMap;
	private GeneralReport generalReport;
		
	public FileProcessor(
			SalesmanLayout salesmanLayout,
			CustomerLayout customerLayout,
			SaleLayout saleLayout,
			Map<String, Salesman> salesmanMap,
			Map<String, Customer> customerMap,
			Map<Integer, Sale> saleMap,
			GeneralReport generalReport
		) {
		this.salesmanLayout = salesmanLayout;
		this.customerLayout = customerLayout;
		this.saleLayout = saleLayout;
		this.salesmanMap = salesmanMap;
		this.customerMap = customerMap;
		this.saleMap = saleMap;
		this.generalReport = generalReport;
	}

	public void process(String[] lines) {
		FileReport fileReport = new FileReport();
		saleLayout.setSalesmanMap(salesmanMap);
		
		for (String line : lines) {
			LineProcessor lineProcessor = new LineProcessor(
					salesmanLayout,
					customerLayout,
					saleLayout,
					salesmanMap,
					customerMap,
					saleMap,
					generalReport,
					fileReport
			);
			lineProcessor.analyze(line);
		}
		System.out.println(fileReport);
	}

}
