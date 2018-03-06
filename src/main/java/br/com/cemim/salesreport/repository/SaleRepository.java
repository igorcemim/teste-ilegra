package br.com.cemim.salesreport.repository;

import br.com.cemim.salesreport.business.Sale;

public class SaleRepository extends AbstractRepository<Sale, Integer> {

	public void add(Sale entry) {
		map.put(entry.getId(), entry);
	}

}
