package br.com.squirtlesquad.main;

import br.com.squirtlesquad.DAOMysql.MysqlProdutoDao;
import br.com.squirtlesquad.obj.Produto;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AtualizaProduto")
public class AtualizaProduto extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("id"));
        System.out.println(request.getParameter("action"));

        MysqlProdutoDao produtoDao = new MysqlProdutoDao();
        Produto prod = new Produto();
        prod.setNome(request.getParameter("nome"));
        prod.setDescricao(request.getParameter("descricao"));
        prod.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
        prod.setUnidadeMedida(request.getParameter("unidadeMedida"));
        DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        Date date = new Date();
        try {
            date = (Date) formatter.parse(request.getParameter("dataValidade"));
        } catch (ParseException ex) {
            System.out.println("Erro ao converter data");
        }
        prod.setDataValidade(date);
        prod.setPromocao(Integer.parseInt(request.getParameter("promocao")));
        prod.setPorcentagemPromocao(Double.parseDouble(request.getParameter("porcentagemPromocao")));
        prod.setQuantidadeMinDesconto(Integer.parseInt(request.getParameter("quantidadeMinDesconto")));
        prod.setCaminhoImagem(request.getParameter("caminhoImagem"));
        prod.setValorUnidade(Double.parseDouble(request.getParameter("valorUnidade")));
        produtoDao.updateProduto(prod, request.getParameter("id"));
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
