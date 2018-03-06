import br.com.cemim.salesreport.application.Application;
import br.com.cemim.salesreport.application.Watcher;

public class Main {
	
	public static void main(String[] args) throws Exception {
		String home = System.getProperty("user.home");
		String inputPath = home + "/data/in";
		String outputPath = home + "/data/out";

		Application application = new Application(inputPath, outputPath);
		application.run();
		
		Watcher watcher = new Watcher(application, inputPath);
		watcher.watch();
	}

}
