package com.java.custemjstl;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class RajeshHandler extends TagSupport {

	@Override
	public int doStartTag() throws JspException {
		 JspWriter out=pageContext.getOut();
		 try {
			out.println("Hi I am Rajesh...From Sonix Training batch...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return SKIP_BODY;
	}
}