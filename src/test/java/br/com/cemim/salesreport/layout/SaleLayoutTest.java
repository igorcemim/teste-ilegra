package br.com.cemim.salesreport.layout;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.cemim.salesreport.business.Sale;
import br.com.cemim.salesreport.business.Salesman;
import br.com.cemim.salesreport.repository.SalesmanRepository;

import static org.junit.Assert.*;

import org.junit.Before;

public class SaleLayoutTest {
	
	@Mock
	private SalesmanRepository salesmanRepository;

	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testSale() {
		SaleLayout layout = new SaleLayout();
		layout.setSalesmanRepository(salesmanRepository);

		Salesman salesman = new Salesman();
		salesman.setName("Diego");
		Mockito.when(salesmanRepository.findByName("Diego")).thenReturn(salesman);

		Sale sale = layout.read("003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego");
		assertEquals(10, sale.getId());
		assertEquals("Diego", sale.getSalesman().getName());
	}
}
