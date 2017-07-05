package br.com.squirtlesquad.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import br.com.squirtlesquad.DAOFactory.DAOFactory;
import br.com.squirtlesquad.DAOInterface.PessoaDao;
import br.com.squirtlesquad.DAOMysql.MysqlDAOFactory;
import br.com.squirtlesquad.DAOMysql.MysqlPessoaDao;
import br.com.squirtlesquad.DAOMysql.MysqlProdutoDao;
import br.com.squirtlesquad.DAOMysql.MysqlVendaDao;
import br.com.squirtlesquad.obj.Pessoa;
import br.com.squirtlesquad.obj.Produto;
import br.com.squirtlesquad.obj.Venda;

public class Main {
	public static DAOFactory dao = null;

	public static void main(String[] args) throws ParseException {

		Connection conn = null;
		conn = MysqlDAOFactory.ConnectDb();

		Produto p = new Produto();
		Pessoa pe = new Pessoa();
		p.setId(1);
		pe.setId("1");
		p.setValorUnidade(10);
		p.setPromocao(0);


		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		Date data = new Date(System.currentTimeMillis());

		Venda v = new Venda();

		
		MysqlVendaDao VendaDao = new MysqlVendaDao();
		
		v.setDataVenda();
		v.addProduto(p);
		v.setPessoa(pe);
		VendaDao.insertVenda(v);
		
		
		


		
		
		


	}

}
