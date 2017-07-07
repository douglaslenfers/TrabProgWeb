/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.squirtlesquad.main;

import br.com.squirtlesquad.DAOMysql.MysqlProdutoDao;
import br.com.squirtlesquad.DAOMysql.MysqlVendaDao;
import br.com.squirtlesquad.obj.Produto;
import br.com.squirtlesquad.obj.Venda;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
@WebServlet("/AdicionarVenda")
public class AdicionarVenda extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static int contador = 1;
    private List<Produto> produtos = new ArrayList();

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println(action);
        String id = request.getParameter("id");
        if (action.equalsIgnoreCase("delete")) {
            Produto p = new Produto();

        }  if (action.equalsIgnoreCase("limpar")) {
            produtos = new ArrayList();
        }if (action.equalsIgnoreCase("finalizar")){
            MysqlVendaDao vendaDao = new MysqlVendaDao();
            Venda venda = new Venda();
            venda.setDataVenda();
            venda.setIdVenda(contador);
            for(Produto p : produtos){
                venda.addProduto(p);
                venda.setQuantidade(p.getQuantidadeVendida());
                vendaDao.insertVenda(venda);
                
            }
            contador++;
            produtos = new ArrayList();
            
            
        }
        //request.setAttribute("lista", produtos);
        MysqlProdutoDao produtoDao = new MysqlProdutoDao();
        Produto produto = produtoDao.selectProduto(request.getParameter("produto"));
        request.setAttribute("listaProduto", produtoDao.selectAllProduto());
        String destino = "caixa.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(destino);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        /*if(contador == 0){
            MysqlVendaDao vendaDao = new MysqlVendaDao();
            MysqlProdutoDao produtoDao = new MysqlProdutoDao();
            Produto p = produtoDao.selectProduto(request.getParameter("nome"));
            Venda venda = new Venda();
            venda.addProduto(p);
           // venda.setIdVenda();
            vendaDao.insertVenda(venda);
            
        }*/
        MysqlProdutoDao produtoDao = new MysqlProdutoDao();
        Produto produto = produtoDao.selectProduto(request.getParameter("produto")); //request.getParameter("nome")
        produto.setQuantidadeVendida(Integer.parseInt(request.getParameter("quantidade")));
        
        
        produtos.add(produto);

        request.setAttribute("lista", produtos);
        request.setAttribute("listaProduto", produtoDao.selectAllProduto());

        String destino = "caixa.jsp";

        RequestDispatcher rd = request.getRequestDispatcher(destino);
        rd.forward(request, response);
    }
}
