package br.com.squirtlesquad.main;

import br.com.squirtlesquad.DAOMysql.MysqlPessoaDao;
import br.com.squirtlesquad.DAOMysql.MysqlProdutoDao;
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

@WebServlet("/ValidarAcesso")
public class ValidarAcesso extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        MysqlPessoaDao pessoaDao = new MysqlPessoaDao();
        List<Pessoa> listaPessoa = new ArrayList<>();
        Pessoa p = new Pessoa();
        p = pessoaDao.verificarAcesso(user, pass);
        String destino = "Caixa";
        if (p.getTipo().equals("caixa")) {
            destino = "caixa.jsp";
            MysqlProdutoDao produtoDao = new MysqlProdutoDao();
            request.setAttribute("listaProduto", produtoDao.selectAllProduto());

        } else if (p.getTipo().equals("gerente")) {
            MysqlProdutoDao produtoDao = new MysqlProdutoDao();
            destino = "gerente.jsp";
            request.setAttribute("listaProdutos", produtoDao.selectAllProduto());
        }
        if (p.getTipo().equals("admin")) {
            destino = "admin.jsp";
            request.setAttribute("listaPessoa", pessoaDao.selectAllPessoa());

        }

        RequestDispatcher rd = request.getRequestDispatcher(destino);
        rd.forward(request, response);
    }
}
