package br.com.cemim.salesreport.repository;

import br.com.cemim.salesreport.business.Customer;

public class CustomerRepository extends AbstractRepository<Customer, String> {

	public void add(Customer customer) {
		map.put(customer.getName(), customer);
	}

}
