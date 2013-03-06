package com.caimingqin.app.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UploadFileServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");

//		ServletInputStream in = req.getInputStream();
//		String path = req.getParameter("path");
//		String filename = req.getParameter("filename");
//		String parameter = req.getParameter("pro");
//	   System.out.println(parameter+""+ path+"  "+filename+"=======================>>"+in.available());
//	   System.out.println(path+"  "+filename+"=======================>>"+outputStream.);
//	   resp.getOutputStream().write(90000);
	
		String username = req.getParameter("username");
		String password = req.getParameter("password");
	
		System.out.println("username" +">>"+username);
		System.out.println("password" +">>"+ password);
		resp.getWriter().write("aaaaaaaaaaaaaaaaaaaaaaaaaaa");

		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
