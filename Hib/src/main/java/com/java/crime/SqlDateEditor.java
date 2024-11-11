package com.java.crime;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SqlDateEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date utilDate = sdf.parse(text);
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			setValue(sqlDate);
		} catch (ParseException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}
}