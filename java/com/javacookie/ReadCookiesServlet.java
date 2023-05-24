package com.javacookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/read_cookies")
public class ReadCookiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReadCookiesServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		
		if (cookies == null) {
			writer.println("Nenhum cookie encontrado");
		} else {
			writer.println("Toda de cookies: " + cookies.length);
			
			for (Cookie aCookie : cookies) {
				String name = aCookie.getName();
				String value = aCookie.getValue();
				
				writer.println(name + " = " + value);
			}
		}
	}

}

