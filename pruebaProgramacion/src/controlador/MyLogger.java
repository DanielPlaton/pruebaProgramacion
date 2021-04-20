package controlador;



import java.net.URL;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



public  class MyLogger {

	public static  Logger logger;
	
	public static void createLogger() {
		
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		String ruta = "C:\\Users\\Daniel\\Desktop\\pruebaProgramacion\\pruebaProgramacion\\src\\resources\\log4j.properties";
		URL url = loader.getResource(ruta);
		PropertyConfigurator.configure(ruta);

	}
	
	public static Logger crearLogger(Class clase) {
		
		logger = LogManager.getLogger(clase);
		return logger;
		
		
	}
}
