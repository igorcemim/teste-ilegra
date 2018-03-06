package br.com.cemim.salesreport.layout;

import br.com.cemim.salesreport.business.Customer;

public class CustomerLayout extends AbstractLayout<Customer> {
	
	public static final String LAYOUT_CODE = "002";
	
	public static final int FIELD_CODE = 0;
	public static final int FIELD_CNPJ = 1;
	public static final int FIELD_NAME = 2;
	public static final int FIELD_BUSINESS_AREA = 3;

	@Override
	public Customer read(String line) {
		int fieldIndex = 0;
		Customer customer = new Customer();

		for (String field : line.split(FIELD_DELIMITER)) {

			switch (fieldIndex) {

				case FIELD_CNPJ:
					customer.setCnpj(field);
					break;
				
				case FIELD_NAME:
					customer.setName(field);
					break;

				case FIELD_BUSINESS_AREA:
					customer.setBusinessArea(field);
					break;

			}
			fieldIndex++;
		}

		return customer;
	}

}
