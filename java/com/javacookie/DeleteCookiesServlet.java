package com.javacookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete_cookies")
public class DeleteCookiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteCookiesServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null) {
			for (Cookie aCookie : cookies) {
				aCookie.setMaxAge(0);
				response.addCookie(aCookie);
			}
			
			writer.println("Todos cookies Apagados!");
		} else {
			writer.println("Nenhum cookie encontrado");
		}
		
	}

}

