package br.com.cemim.salesreport.processor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import br.com.cemim.salesreport.business.Customer;
import br.com.cemim.salesreport.business.FileReport;
import br.com.cemim.salesreport.business.GeneralReport;
import br.com.cemim.salesreport.business.Sale;
import br.com.cemim.salesreport.business.Salesman;
import br.com.cemim.salesreport.layout.CustomerLayout;
import br.com.cemim.salesreport.layout.SaleLayout;
import br.com.cemim.salesreport.layout.SalesmanLayout;
import br.com.cemim.salesreport.processor.FileProcessor;

public class DirectoryProcessor {
	
	private GeneralReport generalReport;
	
	private List<FileReport> filesReports;
	
	private String inputPath;
	
	public DirectoryProcessor(String inputPath, GeneralReport generalReport, List<FileReport> filesReports) {
		this.inputPath = inputPath;
		this.generalReport = generalReport;
		this.filesReports = filesReports;
	}
	
	public void process() throws IOException {
		Map<String, Salesman> salesmanMap = new HashMap<>();
		Map<String, Customer> customerMap = new HashMap<>();
		Map<Integer, Sale> saleMap = new HashMap<>();
		
		SalesmanLayout salesmanLayout = new SalesmanLayout();
		CustomerLayout customerLayout = new CustomerLayout();
		SaleLayout saleLayout = new SaleLayout();
		saleLayout.setSalesmanMap(salesmanMap);

		FileProcessor processor = new FileProcessor(
				salesmanLayout,
				customerLayout,
				saleLayout,
				salesmanMap,
				customerMap,
				saleMap,
				generalReport
		);
		
		Files.list(Paths.get(inputPath))
        	.filter(p -> p.toString().endsWith(".dat"))
        	.forEach(p -> {
        		try {
					Stream<String> lines = Files.lines(p);
					FileReport report = processor.process(lines);
					report.setFile(p.toString());
					filesReports.add(report);
				} catch (IOException e) {
					e.printStackTrace();
				}   		
        	});

		try {
			Salesman worstSalesman = salesmanMap.values()
					.stream()
					.min(Comparator.comparingDouble(Salesman::getSales))
					.get();
			generalReport.setWorstSalesman(worstSalesman);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

}
