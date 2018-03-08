package br.com.cemim.salesreport.processor.line;

import java.util.Map;

import br.com.cemim.salesreport.business.GeneralReport;
import br.com.cemim.salesreport.business.Sale;
import br.com.cemim.salesreport.business.Salesman;
import br.com.cemim.salesreport.layout.SaleLayout;

public class SaleLine implements Line {

    private SaleLayout saleLayout;
    private Map<Integer, Sale> saleMap;
    private GeneralReport generalReport;

    public SaleLine(
        SaleLayout saleLayout,
        Map<Integer, Sale> saleMap,
        GeneralReport generalReport
    ) {
        this.saleLayout = saleLayout;
        this.saleMap = saleMap;
        this.generalReport = generalReport;
    }

    public void process(String line) {
        Sale sale = saleLayout.read(line);
        if (generalReport.getMostExpensiveSale() == null) {
            generalReport.setMostExpensiveSale(sale);
        }
        if (sale.getTotal() > generalReport.getMostExpensiveSale().getTotal()) {
            generalReport.setMostExpensiveSale(sale);
        }
        Salesman saleSalesman = sale.getSalesman();
        saleSalesman.addSale(sale.getTotal());;
        saleMap.put(sale.getId(), sale);
    }

}
