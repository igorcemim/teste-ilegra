package br.com.cemim.salesreport.repository;

import org.junit.Test;

import br.com.cemim.salesreport.business.Salesman;

import static org.junit.Assert.*;

public class SalesmanRepositoryTest {

	@Test
	public void testAddEntry() {
		
		Salesman entry = new Salesman();
		entry.setName("Igor");

		SalesmanRepository salesmanRepository = new SalesmanRepository();
		salesmanRepository.add(entry);

		Salesman entry2 = salesmanRepository.find("Igor");
		assertEquals(entry, entry2);
	}

}
