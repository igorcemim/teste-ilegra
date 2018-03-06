package br.com.cemim.salesreport.layout;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.cemim.salesreport.business.Sale;
import br.com.cemim.salesreport.business.Salesman;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;

public class SaleLayoutTest {
	
	@Mock
	private Map<String, Salesman> salesmanMap;

	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testSale() {
		SaleLayout layout = new SaleLayout();
		layout.setSalesmanMap(salesmanMap);

		Salesman salesman = new Salesman();
		salesman.setName("Diego");
		Mockito.when(salesmanMap.get("Diego")).thenReturn(salesman);

		Sale sale = layout.read("003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego");
		assertEquals(10, sale.getId());
		assertEquals("Diego", sale.getSalesman().getName());
	}
}
