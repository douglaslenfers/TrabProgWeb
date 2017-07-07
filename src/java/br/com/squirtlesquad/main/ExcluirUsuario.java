package br.com.squirtlesquad.main;

import br.com.squirtlesquad.DAOMysql.MysqlPessoaDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ExcluirUsuario")
public class ExcluirUsuario extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        MysqlPessoaDao pessoaDao = new MysqlPessoaDao();
        if (action.equalsIgnoreCase("delete")) {
            pessoaDao.removePessoa(request.getParameter("id"));

        } else if (action.equalsIgnoreCase("edit")) {

            request.setAttribute("editPessoa", pessoaDao.selectPessoa(request.getParameter("id")));
        }

        request.setAttribute("listaPessoa", pessoaDao.selectAllPessoa());
        String destino = "admin.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(destino);
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    }
}
