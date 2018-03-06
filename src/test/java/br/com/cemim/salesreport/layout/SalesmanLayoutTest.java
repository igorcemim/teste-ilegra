package br.com.cemim.salesreport.layout;

import org.junit.Test;

import br.com.cemim.salesreport.business.Salesman;

import static org.junit.Assert.*;

public class SalesmanLayoutTest {

	@Test
	public void testSalesman() {
		SalesmanLayout layout = new SalesmanLayout();
		Salesman salesman = layout.read("001ç3245678865434çRenatoç40000.99");

		assertEquals("3245678865434", salesman.getCpf());
		assertEquals("Renato", salesman.getName());
		assertEquals(40000.99, salesman.getSalary(), 0.001);
	}

}
