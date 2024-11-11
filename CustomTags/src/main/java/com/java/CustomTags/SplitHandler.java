package com.java.CustomTags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class SplitHandler extends BodyTagSupport {

	@Override
	public int doStartTag() throws JspException {
		return EVAL_BODY_BUFFERED;
	}
	
	@Override
	public int doEndTag() throws JspException {
		String body = bodyContent.getString();
		String[] data = body.split(" ");
		 JspWriter out=pageContext.getOut();
		try {
			for (String s : data) {
				out.println(s+ "<Br/>");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
}