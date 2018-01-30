package cn.app.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 进行日期转换的类
 * 
 * @author Administrator
 * 
 */
public class StringToDateConverter implements Converter<String, Date> {

	private String datePattern;

	public StringToDateConverter(String datePattern) {
		this.datePattern = datePattern;
	}

	@Override
	public Date convert(String s) {
		// TODO Auto-generated method stub
		Date date = null;
		try {
			date = new SimpleDateFormat(datePattern).parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

}
