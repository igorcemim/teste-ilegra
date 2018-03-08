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
import br.com.cemim.salesreport.processor.line.CustomerLine;
import br.com.cemim.salesreport.processor.line.Line;
import br.com.cemim.salesreport.processor.line.SaleLine;
import br.com.cemim.salesreport.processor.line.SalesmanLine;

public class LineProcessor {

	private SalesmanLayout salesmanLayout;
	private CustomerLayout customerLayout;
	private SaleLayout saleLayout;

	private Map<Integer, Sale> saleMap;
	private Map<String, Customer> customerMap;
	private Map<String, Salesman> salesmanMap;
	private GeneralReport generalReport;
	private FileReport fileReport;

	private static final int LAYOUT_CODE_POSITION_START = 0;
	private static final int LAYOUT_CODE_POSITION_END = 3;

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

	public void process(String line) throws Exception {
		Line lineImplementation = null;
		switch (line.substring(LAYOUT_CODE_POSITION_START, LAYOUT_CODE_POSITION_END)) {

			case SalesmanLayout.LAYOUT_CODE:
				lineImplementation = new SalesmanLine(salesmanLayout, salesmanMap, fileReport);
				break;

			case CustomerLayout.LAYOUT_CODE:
				lineImplementation = new CustomerLine(customerLayout, customerMap, fileReport);
				break;

			case SaleLayout.LAYOUT_CODE:
				lineImplementation = new SaleLine(saleLayout, saleMap, generalReport);
				break;

			default:
				throw new Exception("Linha inválida.");
		}
		lineImplementation.process(line);
	}
}
