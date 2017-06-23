package br.com.squirtlesquad.DAOMysql;

import br.com.squirtlesquad.DAOFactory.DAOFactory;
import br.com.squirtlesquad.DAOInterface.PessoaDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class MysqlDAOFactory extends DAOFactory {

    public PreparedStatement ps;
    public static Connection cone;

    public static Connection ConnectDb() {
        try {
        	
            Class.forName("mysql-connector-java-5.1.42-bin"); //C:\Users\André\OneDrive\workspace\Copy of Copy of Trabalho Final
            cone = DriverManager.getConnection("jdbc:mysql://127.0.0.1/squirtle_squad","root","toor");
            //JOptionPane.showMessageDialog(null, "CONNECTION ESTABLISHED biblioteca");
            return cone;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public void desconectar() {// Metodo para fechar a conexao do bd
        try {
            cone.close();// fecha a conexao
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public PessoaDao getPessoaDao() {
        // TODO Auto-generated method stub
        return new MysqlPessoaDao();
    }


}
