package br.com.cemim.salesreport.application;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import br.com.cemim.salesreport.business.Customer;
import br.com.cemim.salesreport.business.GeneralReport;
import br.com.cemim.salesreport.business.Sale;
import br.com.cemim.salesreport.business.Salesman;
import br.com.cemim.salesreport.layout.CustomerLayout;
import br.com.cemim.salesreport.layout.SaleLayout;
import br.com.cemim.salesreport.layout.SalesmanLayout;
import br.com.cemim.salesreport.processor.FileProcessor;

public class Application {
	
	public void run() throws Exception {

		Map<String, Salesman> salesmanMap = new HashMap<>();
		Map<String, Customer> customerMap = new HashMap<>();
		Map<Integer, Sale> saleMap = new HashMap<>();
		
		SalesmanLayout salesmanLayout = new SalesmanLayout();
		CustomerLayout customerLayout = new CustomerLayout();
		SaleLayout saleLayout = new SaleLayout();
		saleLayout.setSalesmanMap(salesmanMap);

		GeneralReport generalReport = new GeneralReport();

		FileProcessor processor = new FileProcessor(
				salesmanLayout,
				customerLayout,
				saleLayout,
				salesmanMap,
				customerMap,
				saleMap,
				generalReport
		);
		
		String file =
				"001ç1234567891234çDiegoç50000\n" + 
				"001ç3245678865434çRenatoç40000.99\n" + 
				"002ç2345675434544345çJose da SilvaçRural\n" + 
				"002ç2345675433444345çEduardo PereiraçRoupas e Calcados\n" + 
				"003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego\n" +
				"003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çRenato";

		processor.process(file.split("\n"));
		processor.process(file.split("\n"));
		processor.process(file.split("\n"));

		Salesman worstSalesman = salesmanMap.values()
				.stream()
				.min(Comparator.comparingDouble(Salesman::getSales))
				.get();
		
		generalReport.setWorstSalesman(worstSalesman);
		
		System.out.println(generalReport);
	}

}
