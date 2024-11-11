package com.java.CustomTags;

import java.io.IOException;

import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class DateHandler extends TagSupport {

	public int doStartTag() throws JspException {
		 JspWriter out=pageContext.getOut();
		 Date date = new Date();
		 try {
			out.println("Today's date " +date.getDate() + " Time is " +date.getHours() + ":" +date.getMinutes() + ":" +
			 date.getSeconds());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// the DateHandler tag contains no body as we need to use
		return SKIP_BODY;
	}
}
