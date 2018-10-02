package Utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class SupportUtils {

	private static Properties prop;
	private static Properties ORprop;
	static{
		prop=new Properties(); 
		ORprop=new Properties(); 
	
		try {
			//loading Config Prop
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/test/config/config.properties");
			prop.load(ip);
			
			//loading OR Prop
			ip = new FileInputStream(System.getProperty("user.dir")+"/src/test/config/OR.properties");
			ORprop.load(ip);
			
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static Properties getproperty()
	{
		return prop;

	}
	
	public static Properties getORproperty()
	{
		return ORprop;

	}
	
	
	public static  String  Browser(){

		String name =prop.getProperty("Browser");

		return name;
	}

	public static String  path()
	{
		String name =prop.getProperty("path");
		return name ;
	}
	
	
	public static String  getLocatorVal(String value)
	{
		String val =prop.getProperty(value);
		return val ;
	}

}

