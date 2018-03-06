package br.com.cemim.salesreport.layout;

import br.com.cemim.salesreport.repository.SalesmanRepository;

public class Processor {
	
	private SalesmanLayout salesmanLayout;
	private CustomerLayout customerLayout;
	private SaleLayout saleLayout;
	private String home;
	
	public Processor(SalesmanLayout salesmanLayout, CustomerLayout customerLayout, SaleLayout saleLayout, String home) {
		this.salesmanLayout = salesmanLayout;
		this.customerLayout = customerLayout;
		this.saleLayout = saleLayout;
		this.home = home;
	}

	public void process(String[] lines) {
		
		SalesmanRepository salesmanRepository = new SalesmanRepository();
		saleLayout.setSalesmanRepository(salesmanRepository);
		
		for (String line : lines) {
			switch (line.substring(0, 3)) {

				case SalesmanLayout.LAYOUT_CODE:
					System.out.println(salesmanLayout.read(line));
					break;

				case CustomerLayout.LAYOUT_CODE:
					System.out.println(customerLayout.read(line));
					break;

				case SaleLayout.LAYOUT_CODE:
					System.out.println(saleLayout.read(line));
					break;
			}
		}
	}

}
