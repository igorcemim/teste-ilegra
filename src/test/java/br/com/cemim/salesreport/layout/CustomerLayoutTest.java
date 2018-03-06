package br.com.cemim.salesreport.layout;

import org.junit.Test;

import br.com.cemim.salesreport.business.Customer;

import static org.junit.Assert.*;

public class CustomerLayoutTest {
	
	@Test
	public void testCustomer() {
		CustomerLayout layout = new CustomerLayout();
		Customer customer = layout.read("002ç2345675434544345çJose da SilvaçRural");
		
		assertEquals("2345675434544345", customer.getCnpj());
		assertEquals("Jose da Silva", customer.getName());
		assertEquals("Rural", customer.getBusinessArea());
	}
}
