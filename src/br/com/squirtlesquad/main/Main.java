package br.com.squirtlesquad.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.squirtlesquad.DAOFactory.DAOFactory;
import br.com.squirtlesquad.DAOInterface.PessoaDao;
import br.com.squirtlesquad.DAOMysql.MysqlDAOFactory;
import br.com.squirtlesquad.DAOMysql.MysqlPessoaDao;
import br.com.squirtlesquad.obj.Pessoa;

public class Main {
	public static DAOFactory dao = null;

	public static void main(String[] args) {

		Connection conn = null;
		conn = MysqlDAOFactory.ConnectDb();
		MysqlPessoaDao pessoaDao = new MysqlPessoaDao();
		Pessoa p = new Pessoa();
		p = pessoaDao.selectPessoa("2");
		System.out.println(p.getNome());

	}

}
