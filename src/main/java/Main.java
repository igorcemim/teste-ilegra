import br.com.cemim.salesreport.application.Application;
import br.com.cemim.salesreport.application.Watcher;

public class Main {
	
	public static void main(String[] args) throws Exception {
		Application application = new Application();
		application.run();
		
		Watcher watcher = new Watcher(application);
		watcher.watch();
	}

}
