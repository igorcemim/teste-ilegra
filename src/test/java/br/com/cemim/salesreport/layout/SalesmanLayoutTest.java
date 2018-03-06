package br.com.cemim.salesreport.layout;

import org.junit.Test;

import br.com.cemim.salesreport.business.Salesman;

import static org.junit.Assert.*;

public class SalesmanLayoutTest {
	
	@Test
	public void testSalesman() {
		SalesmanLayout salesmanLayout = new SalesmanLayout();
		Salesman business = salesmanLayout.read("001ç3245678865434çRenatoç40000.99");
	}

}
