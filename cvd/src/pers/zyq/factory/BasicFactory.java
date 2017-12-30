package pers.zyq.factory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BasicFactory {

	private static BasicFactory  factory=new BasicFactory();
	private static Properties prop=null;
	private BasicFactory(){
		super();
	}
	public static BasicFactory getFactory(){
		return factory;
	}
	static{
		prop=new Properties();
		try {
			prop.load(new FileReader(BasicFactory.class.getClassLoader().getResource("config.properties").getPath()));
		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	public <T>T getInstance(Class<T> clazz){
		String infName=clazz.getSimpleName();
		String impName=prop.getProperty(infName);
		try {
			return (T) clazz.forName(impName).newInstance();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			throw new RuntimeException();
		} 
	}
}
