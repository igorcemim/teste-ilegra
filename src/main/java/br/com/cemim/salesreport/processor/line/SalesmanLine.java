package br.com.cemim.salesreport.processor.line;

import java.util.Map;

import br.com.cemim.salesreport.business.FileReport;
import br.com.cemim.salesreport.business.Salesman;
import br.com.cemim.salesreport.layout.SalesmanLayout;

public class SalesmanLine implements Line {

    SalesmanLayout salesmanLayout;
    Map<String, Salesman> salesmanMap;
    FileReport fileReport;

    public SalesmanLine(
        SalesmanLayout salesmanLayout,
        Map<String, Salesman> salesmanMap,
        FileReport fileReport
    ) {
        this.salesmanLayout = salesmanLayout;
        this.salesmanMap = salesmanMap;
        this.fileReport = fileReport;
    }

    public void process(String line) {
        Salesman salesman = salesmanLayout.read(line);
        if (!salesmanMap.containsKey(salesman.getName())) {
            salesmanMap.put(salesman.getName(), salesman);
        }
        fileReport.incrementAmountSalesman();
    }

}
