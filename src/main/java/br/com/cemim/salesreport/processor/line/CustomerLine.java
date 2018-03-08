package br.com.cemim.salesreport.processor.line;

import java.util.Map;

import br.com.cemim.salesreport.business.Customer;
import br.com.cemim.salesreport.business.FileReport;
import br.com.cemim.salesreport.layout.CustomerLayout;

public class CustomerLine implements Line {

	private CustomerLayout customerLayout;
	private Map<String, Customer> customerMap;
	private FileReport fileReport;

	public CustomerLine(
			CustomerLayout customerLayout,
			Map<String, Customer> customerMap,
			FileReport fileReport
		) {
		this.customerLayout = customerLayout;
		this.customerMap = customerMap;
		this.fileReport = fileReport;
	}

	public void process(String line) {
        Customer customer = customerLayout.read(line);
        if (!customerMap.containsKey(customer.getName()) ) {
            customerMap.put(customer.getName(), customer);
        }

        fileReport.incrementAmountClients();
	}
}
