package js.com.br.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Company {
	private int id;
	private String name;
	private Date date;

	public Company(String name, Date openDate) {
		this.name = name;
		this.date = openDate;
	}
	
	public Company(String name, String openDate) throws ParseException {
		this.name = name;
		this.date = parseStringToDate(openDate);
		
	}
	
	private Date parseStringToDate(String value) throws ParseException {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			date = sdf.parse(value);
		} catch (ParseException e) {
			throw e;
		}
		
		return date;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(String value) throws ParseException {
		this.date = parseStringToDate(value);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
