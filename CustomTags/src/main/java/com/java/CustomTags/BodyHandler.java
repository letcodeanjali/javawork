package com.java.CustomTags;
import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class BodyHandler extends BodyTagSupport {

	public int doStartTag() throws JspException {
		return EVAL_BODY_BUFFERED;
	}
	
	public int doEndTag() throws JspException {
		String body = bodyContent.getString();
		 JspWriter out=pageContext.getOut();
		body = body.toUpperCase();
		try {
			out.println(body);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
}
