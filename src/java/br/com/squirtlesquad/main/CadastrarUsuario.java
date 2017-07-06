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

@WebServlet("/CadastrarUsuario")
public class CadastrarUsuario extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        Pessoa p = new Pessoa();
        List<Pessoa> listaPessoa = new ArrayList<>();
        p.setNome(request.getParameter("nome"));
        p.setSenha(request.getParameter("senha"));
        p.setTipo(request.getParameter("perfil"));

        MysqlPessoaDao pessoaDao = new MysqlPessoaDao();

        pessoaDao.insertPessoa(p);

        listaPessoa = pessoaDao.selectAllPessoa();
        request.setAttribute("listaPessoa", listaPessoa);
        String destino = "admin.jsp";

        //O sistema é direcionado para a página 
        //sucesso.jsp Se tudo ocorreu bem
        //erro.jsp se houver algum problema.
        RequestDispatcher rd = request.getRequestDispatcher(destino);
        rd.forward(request, response);
    }
}
