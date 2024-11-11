package com.java.CustomTags;

import java.io.IOException;

import java.util.jar.JarException;

import javax.servlet.jsp.tagext.TagSupport;
import javax.swing.JSpinner;

public class RajeshHandler extends TagSupport {

	public int doStartTag() throws JarException {
		 JSpinner out=pageContext.getOut();
		 try {
			out.println("Hi I am Rajesh...From Sonix Training batch...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return SKIP_BODY;
	}
}
