package br.com.cemim.salesreport.application;

import java.util.ArrayList;
import java.util.List;

import br.com.cemim.salesreport.business.FileReport;
import br.com.cemim.salesreport.business.GeneralReport;
import br.com.cemim.salesreport.processor.DirectoryProcessor;

public class Application {
	
	private String inputPath;
	
	private String outputPath;
	
	public Application(String in, String out) {
		this.inputPath = in;
		this.outputPath = out;
	}
	
	public void run() throws Exception {
		List<FileReport> filesReports = new ArrayList<>();
		GeneralReport generalReport = new GeneralReport();
		DirectoryProcessor directoryProcessor = new DirectoryProcessor(
				inputPath,
				generalReport,
				filesReports
		);
		System.out.println("Processando arquivos...\n");
		directoryProcessor.process();
		System.out.println("Arquivos processados.\n");
		
		ReportWriter reportWriter = new ReportWriter(outputPath, generalReport, filesReports);
		reportWriter.write();
	}

}
