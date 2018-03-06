package br.com.cemim.salesreport.repository;

import br.com.cemim.salesreport.business.Salesman;

public class SalesmanRepository extends AbstractRepository<Salesman, String> {
	
	public void add(Salesman entry) {
		map.put(entry.getName(), entry);
	}

}
