package br.com.cemim.salesreport.layout;

import br.com.cemim.salesreport.business.Sale;
import br.com.cemim.salesreport.business.Salesman;

import java.util.ArrayList;
import java.util.List;

import br.com.cemim.salesreport.business.Item;

public class SaleLayout extends AbstractLayout<Sale> {
	
	public static final String LAYOUT_CODE = "003";
	
	public static final int FIELD_CODE = 0;
	public static final int FIELD_SALE_ID = 1;
	public static final int FIELD_ITEMS = 2;
	public static final int FIELD_SALESMAN_NAME = 3;
	
	public static final int FIELD_ITEM_ID = 1;
	public static final int FIELD_ITEM_QUANTITY = 2;
	public static final int FIELD_ITEM_PRICE = 3;

	@Override
	public Sale read(String line) {
		int fieldIndex = 0;
		Sale sale = new Sale();

		for (String field : line.split(FIELD_DELIMITER)) {

			switch (fieldIndex) {

				case FIELD_SALE_ID:
					sale.setId(Integer.parseInt(field));
					break;
				
				case FIELD_ITEMS:
					List<Item> items = new ArrayList<>();
					sale.setItems(items);
					break;

				case FIELD_SALESMAN_NAME:
					Salesman salesman = new Salesman();
					sale.setSalesman(salesman);
					break;

			}
			fieldIndex++;
		}
System.out.println(sale);
		return sale;
	}

}
