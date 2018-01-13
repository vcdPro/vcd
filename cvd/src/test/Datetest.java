package test;





import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class Datetest {
@Test
	public void test1(){
	Date d=new Date();
	d.setMonth(d.getMonth()+1);
	//Date d1=new Date(2018,1,10);
	String d1="2018-01-02";
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	String datestr=sdf.format(d);
	
	System.out.println(datestr);
		
	}
}
