package jac.finalproject.controller;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;


import java.io.*;

public class HelloTag extends SimpleTagSupport {
	
//	for cuatom tags make sure to do classname extends SimpleTagSupport  

	
	private String message;
	
	public void setMessage(String msg){
		this.message = msg;
	}
	
	StringWriter sw = new StringWriter();

//	@Override
	  public void doTag() throws JspException, IOException {
		  if(message != null){
			  // use message from attribute 
			  JspWriter out = getJspContext().getOut();
			    out.print(message);
		  } else {
			  // use message from body 
			  getJspBody().invoke(sw);
			  getJspContext().getOut().println(sw.toString());
		  }
	  
	  }

}
