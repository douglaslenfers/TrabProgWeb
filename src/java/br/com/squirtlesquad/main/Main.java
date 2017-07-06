package br.com.squirtlesquad.main;

import java.sql.Connection;
import java.text.ParseException;

import br.com.squirtlesquad.DAOFactory.DAOFactory;
import br.com.squirtlesquad.DAOMysql.MysqlDAOFactory;
import br.com.squirtlesquad.DAOMysql.MysqlPessoaDao;
import br.com.squirtlesquad.obj.Pessoa;
import br.com.squirtlesquad.obj.Produto;

public class Main {

    public static DAOFactory dao = null;

    public static void main(String[] args) throws ParseException {

        Connection conn = null;
        conn = MysqlDAOFactory.ConnectDb();

        Produto p = new Produto();
        Pessoa pe = new Pessoa();

        MysqlPessoaDao pee = new MysqlPessoaDao();
        System.out.println(pee.selectPessoa("1"));

    }

}
