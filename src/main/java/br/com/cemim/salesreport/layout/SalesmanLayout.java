package br.com.cemim.salesreport.layout;

import br.com.cemim.salesreport.business.Salesman;

public class SalesmanLayout extends AbstractLayout<Salesman> {
	
	public static final String LAYOUT_CODE = "001";
	
	public static final int FIELD_CODE = 0;
	public static final int FIELD_CPF = 1;
	public static final int FIELD_NAME = 2;
	public static final int FIELD_SALARY = 3;

	@Override
	public Salesman read(String line) {
		int fieldIndex = 0;
		Salesman salesman = new Salesman();

		for (String field : line.split(FIELD_DELIMITER)) {

			switch (fieldIndex) {

				case FIELD_CPF:
					salesman.setCpf(field);
					break;
				
				case FIELD_NAME:
					salesman.setName(field);
					break;

				case FIELD_SALARY:
					salesman.setSalary(Double.parseDouble(field));
					break;

			}
			fieldIndex++;
		}

		return salesman;
	}
	
}
