package configurations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
	private static final String PATH_PROPERTIES = "./config.properties";

	public static String getValue(String value){
		Properties properties = new Properties();
		FileInputStream file = null;
		try {
			file = new FileInputStream(PATH_PROPERTIES);
			properties.load(file);
		} catch (IOException ex){
			System.out.println("Erro ao ler o arquivo de propriedades");
		}
		return properties.getProperty(value);
	}

}
