/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.squirtlesquad.main;

import br.com.squirtlesquad.DAOMysql.MysqlDAOFactory;
import br.com.squirtlesquad.DAOMysql.MysqlPessoaDao;
import br.com.squirtlesquad.obj.Pessoa;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                MysqlPessoaDao pessoaDao = new MysqlPessoaDao();
                List<Pessoa> listaPessoa = new ArrayList<>();
                Pessoa p = new Pessoa();
                p = pessoaDao.verificarAcesso(user, pass);
                String destino = "Caixa";
                if(p.getTipo().equals("Caixa")){
                    destino = "caixa.jsp";
                }else if(p.getTipo().equals("gerente")){
                     destino = "gerente.jsp";
                }if(p.getTipo().equals("admin")){
                     destino = "admin.jsp";

                
   
                }
                request.setAttribute("listaPessoa", pessoaDao.selectAllPessoa());
 
		//O sistema é direcionado para a página 
		//sucesso.jsp Se tudo ocorreu bem
		//erro.jsp se houver algum problema.
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
	}
}