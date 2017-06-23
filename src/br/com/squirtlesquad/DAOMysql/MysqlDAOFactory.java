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
        	
            Class.forName("org.sqlite.JDBC"); //C:\Users\Andr�\OneDrive\workspace\Copy of Copy of Trabalho Final
            cone = DriverManager.getConnection("jdbc:sqlite:C:/Users/Andr�/OneDrive/workspace/Copy of Copy of Trabalho Final/bancoBiblioteca.sqlite");
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