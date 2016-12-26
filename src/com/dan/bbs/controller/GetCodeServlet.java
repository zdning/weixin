package com.dan.bbs.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dan.bbs.common.QRCodeUtil;
import com.dan.bbs.common.MyFilter;



@WebServlet("/GetCodeServlet")
public class GetCodeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String name = request.getParameter("name");
		String openid = request.getParameter("openid");
		System.out.println(name);
		System.out.println(openid);
		
		try {
			String text = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath() + "/CheckInServlet?name=" + name;
			File f = new File(request.getServletContext().getRealPath("/")+ "/tmp/erweima");
			System.out.println(text);
			if (!f.exists()) {
				f.mkdirs();
			}
	        QRCodeUtil.encodeNew(text, request.getServletContext().getRealPath("/")+ "/tmp/erweima", true,name);
	        
		} catch (Exception e) {

		}

	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}