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
            String driverName = "com.mysql.jdbc.Driver";

            Class.forName(driverName);
            cone = DriverManager.getConnection("jdbc:mysql://localhost:3306/squirtle_squad", "root", "toor");
            //JOptionPane.showMessageDialog(null, "CONNECTION ESTABLISHED biblioteca");
            return cone;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public void desconectar() {
        try {
            cone.close();
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
