package com.java.hib;

import java.beans.PropertyEditorSupport;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SqlDateEditor extends PropertyEditorSupport {

	private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		try {
			java.util.Date utilDate = dateFormat.parse(text);
			Date sqlDate = new Date(utilDate.getTime());
			setValue(sqlDate);
		} catch (ParseException e) {
			throw new IllegalArgumentException("Invalid date format. Please use yyyy-MM-dd.", e);
		}
	}

	@Override
	public String getAsText() {
		Date value = (Date) getValue();
		return (value != null ? dateFormat.format(value) : "");
	}
}
