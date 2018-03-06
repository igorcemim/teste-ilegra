import java.util.HashMap;

import br.com.cemim.salesreport.business.GeneralReport;
import br.com.cemim.salesreport.layout.CustomerLayout;
import br.com.cemim.salesreport.layout.Processor;
import br.com.cemim.salesreport.layout.SaleLayout;
import br.com.cemim.salesreport.layout.SalesmanLayout;

public class Main {
	
	public static void main(String[] args) throws Exception {
		SalesmanLayout salesmanLayout = new SalesmanLayout();
		CustomerLayout customerLayout = new CustomerLayout();
		SaleLayout saleLayout = new SaleLayout();
		String home = System.getProperty("user.home");
		
		Processor processor = new Processor(
				salesmanLayout,
				customerLayout,
				saleLayout,
				new HashMap<>(),
				new HashMap<>(),
				new HashMap<>(),
				new GeneralReport()
		);
		String file =
				"001ç1234567891234çDiegoç50000\n" + 
				"001ç3245678865434çRenatoç40000.99\n" + 
				"002ç2345675434544345çJose da SilvaçRural\n" + 
				"002ç2345675433444345çEduardo PereiraçRoupas e Calcados\n" + 
				"003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego\n" +
				"003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çRenato";

		processor.process(file.split("\n"));
	}

}
