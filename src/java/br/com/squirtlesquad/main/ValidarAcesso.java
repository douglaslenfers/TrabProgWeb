package br.com.squirtlesquad.main;

import br.com.squirtlesquad.DAOInterface.VendaDao;
import br.com.squirtlesquad.DAOMysql.MysqlPessoaDao;
import br.com.squirtlesquad.DAOMysql.MysqlProdutoDao;
import br.com.squirtlesquad.DAOMysql.MysqlVendaDao;
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
            destino = "gerente.jsp";
        }
        if (p.getTipo().equals("admin")) {
            destino = "admin.jsp";
            request.setAttribute("listaPessoa", pessoaDao.selectAllPessoa());

        }

        

        //O sistema é direcionado para a página 
        //sucesso.jsp Se tudo ocorreu bem
        //erro.jsp se houver algum problema.
        RequestDispatcher rd = request.getRequestDispatcher(destino);
        rd.forward(request, response);
    }
}
