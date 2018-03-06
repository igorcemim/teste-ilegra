package br.com.cemim.salesreport.application;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class Watcher {
	
	private Application application;
	
	private String inputPath;
	
	public Watcher(Application application, String in) {
		this.application = application;
		this.inputPath = in;
	}
	
	public void watch() throws Exception {
		Path path = Paths.get(inputPath);
		WatchService watchService = FileSystems.getDefault().newWatchService();
		path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
		WatchKey key;
		String message = "Aguardando novos arquivos para reprocessar...\n";
		System.out.println(message);

		while ((key = watchService.take()) != null) {
			key.pollEvents();
			application.run();
			key.reset();
			System.out.println(message);
		}
	}

}
