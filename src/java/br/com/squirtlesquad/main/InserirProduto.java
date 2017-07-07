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

@WebServlet("/InserirProduto")
public class InserirProduto extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        System.out.println(request.getParameter("id"));
        System.out.println(request.getParameter("action"));

        MysqlProdutoDao produtoDao = new MysqlProdutoDao();
        Produto prod = new Produto();
        prod.setNome(request.getParameter("nome_produto"));
        prod.setDescricao(request.getParameter("descricao"));
        prod.setQuantidade(Integer.parseInt(request.getParameter("qtd_produto")));
        prod.setUnidadeMedida(request.getParameter("unMedida_produto"));
        DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        Date date = new Date();
        try {
            date = (Date) formatter.parse(request.getParameter("validade"));
        } catch (ParseException ex) {
            System.out.println("Erro ao converter data");
        }
        prod.setDataValidade(date);
        if (request.getParameter("promocao").equalsIgnoreCase("N")) {
            prod.setPromocao(0);
        } else {
            prod.setPromocao(1);
            prod.setPorcentagemPromocao(Double.parseDouble(request.getParameter("percent_promocao")));
        }

        prod.setQuantidadeMinDesconto(Integer.parseInt(request.getParameter("qtd_min_estoque")));
        prod.setCaminhoImagem(request.getParameter("image_produto"));
        prod.setValorUnidade(Double.parseDouble(request.getParameter("valor")));
        produtoDao.insertProduto(prod);
        request.setAttribute("listaProdutos",
                produtoDao.selectAllProduto());
        String destino = "gerente.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(destino);
        rd.forward(request, response);

    }
}
