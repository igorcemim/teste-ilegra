package br.com.cemim.salesreport.processor;

import java.util.Map;
import java.util.stream.Stream;

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

	public FileReport process(Stream<String> lines) {
		FileReport fileReport = new FileReport();
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
		lines.forEach(line -> {
			try {
				lineProcessor.process(line);
			} catch (Exception e) {
				System.out.println("Erro ao processar linha - " + e.getMessage());
			}
		});

		return fileReport;
	}

}
