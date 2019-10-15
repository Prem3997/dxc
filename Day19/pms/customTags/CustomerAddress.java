package com.dxc.pms.customTags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class CustomerAddress extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		JspWriter out=pageContext.getOut();
		try {
			out.println("<h1>DXCTechnology</h1>"
					+ "DGS-CAMPUS PAHSE-1<br>"
					+ "HP Avenue,39/40,ElectronicCity<br>"
					+ "Bangalore");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.doStartTag();
	}

}
