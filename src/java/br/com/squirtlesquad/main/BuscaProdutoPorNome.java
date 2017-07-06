package br.com.squirtlesquad.main;

import br.com.squirtlesquad.DAOMysql.MysqlProdutoDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BuscaProdutoPorNome")
public class BuscaProdutoPorNome extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("id"));
        System.out.println(request.getParameter("action"));

        MysqlProdutoDao produtoDao = new MysqlProdutoDao();
        produtoDao.selectProdutoId(request.getParameter("nome"));
        request.setAttribute("listaProdutos", produtoDao.selectAllProduto());
        String destino = "gerente.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(destino);
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        System.out.println(request.getParameter("nome"));
        System.out.println(request.getParameter("action"));

        String destino = "gerente.jsp";

        RequestDispatcher rd = request.getRequestDispatcher(destino);
        rd.forward(request, response);
    }
}
