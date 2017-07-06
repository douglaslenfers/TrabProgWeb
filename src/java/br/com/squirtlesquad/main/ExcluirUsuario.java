/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.squirtlesquad.main;

import br.com.squirtlesquad.DAOMysql.MysqlPessoaDao;
import br.com.squirtlesquad.obj.Pessoa;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pizani
 */
@WebServlet("/ExcluirUsuario")
public class ExcluirUsuario extends HttpServlet{
    
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		  System.out.println(request.getParameter("id"));
                  System.out.println(request.getParameter("action"));
                  
                MysqlPessoaDao pessoaDao = new MysqlPessoaDao();
                pessoaDao.removePessoa(request.getParameter("id"));
                request.setAttribute("listaPessoa", pessoaDao.selectAllPessoa());
                String destino = "admin.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
                
	}
 
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


                MysqlPessoaDao pessoaDao = new MysqlPessoaDao();
                
                String action = request.getParameter("action");
               // if (action.equalsIgnoreCase("delete")){
                     System.out.println(request.getParameter("nome"));
                     System.out.println(request.getParameter("action"));
               // }
                
                String destino = "admin.jsp";
 
		//O sistema é direcionado para a página 
		//sucesso.jsp Se tudo ocorreu bem
		//erro.jsp se houver algum problema.
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
	}
}