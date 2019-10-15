package com.dxc.pms.customTags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class PrintName extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int noOfTimes=4;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfTimes() {
		return noOfTimes;
	}

	public void setNoOfTimes(int noOfTimes) {
		this.noOfTimes = noOfTimes;
	}

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		for(int i=0;i<noOfTimes;i++) {
			JspWriter out=pageContext.getOut();
			try {
				out.println(name);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return super.doStartTag();
	}

}
