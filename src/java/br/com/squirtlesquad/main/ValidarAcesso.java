/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.squirtlesquad.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pizani
 */
@WebServlet("/ValidarAcesso")
public class ValidarAcesso extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
 
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
                String pass = request.getParameter("pass");
                System.out.println(user + " " +pass);
                   
 
		//O sistema é direcionado para a página 
		//sucesso.jsp Se tudo ocorreu bem
		//erro.jsp se houver algum problema.
		//RequestDispatcher rd = request.getRequestDispatcher(destino);
		//rd.forward(request, response);
	}
}