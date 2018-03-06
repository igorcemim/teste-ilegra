package br.com.cemim.salesreport.application;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class Watcher {
	
	private Application application;
	
	public Watcher(Application application) {
		this.application = application;
	}
	
	public void watch() throws Exception {
		String home = System.getProperty("user.home");
		Path path = Paths.get(home + "/data/in");
		WatchService watchService = FileSystems.getDefault().newWatchService();
		path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
		WatchKey key;

		while ((key = watchService.take()) != null) {
			key.pollEvents();
			application.run();
			key.reset();
		}
	}

}
