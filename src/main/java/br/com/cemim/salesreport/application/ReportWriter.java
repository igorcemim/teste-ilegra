package br.com.cemim.salesreport.application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.List;

import br.com.cemim.salesreport.business.FileReport;
import br.com.cemim.salesreport.business.GeneralReport;

public class ReportWriter {

	private String outputPath;
	
	private GeneralReport generalReport;
	
	private List<FileReport> filesReports;
	
	public ReportWriter(String outputPath, GeneralReport generalReport, List<FileReport> filesReports) {
		this.outputPath = outputPath;
		this.generalReport = generalReport;
		this.filesReports = filesReports;
	}
	
	public void write() throws IOException {
		String filename = outputPath + "/" + "report-" + Instant.now().getEpochSecond() + ".done.dat";
		String fullReport = generalReport.toString();
		for (FileReport fileReport : filesReports) {
			fullReport += fileReport.toString();
		}
		Files.write(Paths.get(filename), fullReport.getBytes());
		System.out.println("Relatório gerado com sucesso no caminho: " + filename + "\n");
	}

}
