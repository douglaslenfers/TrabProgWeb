package br.com.squirtlesquad.DAOMysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import br.com.squirtlesquad.DAOInterface.PessoaDao;
import br.com.squirtlesquad.obj.Pessoa;

public class MysqlPessoaDao implements PessoaDao {

    Connection conn = null;
    PreparedStatement ps = null;
    private Pessoa pessoa;

    public MysqlPessoaDao() {
        conn = MysqlDAOFactory.ConnectDb();

    }

    @Override
    public void insertPessoa(Pessoa pessoa) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = MysqlDAOFactory.ConnectDb();
            ps = conn.prepareStatement("INSERT INTO Pessoa (id_user, nome, senha, tipo_usuario) VALUES (?, ?, ?, ?)");
            ps.setString(1, pessoa.getId());
            ps.setString(2, pessoa.getNome());
            ps.setString(3, pessoa.getSenha());
            ps.setString(4, pessoa.getTipo());

            ps.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no MysqlPessoaDao.insertPessoa \n " + ex.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
            }
        }
    }

    @Override
    public void removePessoa(String id_user) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = MysqlDAOFactory.ConnectDb();
            ps = conn.prepareStatement("DELETE FROM Pessoa WHERE id_user = ?");
            ps.setString(1, id_user);
            ps.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no MysqlPessoaDao.removePessoa \n " + ex.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
            }
        }
    }

    @Override
    public void updatePessoa(Pessoa pessoa, String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = MysqlDAOFactory.ConnectDb();
            ps = conn.prepareStatement("UPDATE Pessoa SET nome = ?, id_user = ?, senha = ?, tipo_usuario = ? WHERE id_user = ?");
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getId());
            ps.setString(3, pessoa.getSenha());
            ps.setString(4, pessoa.getTipo());
            ps.setString(5, id);
            ps.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no MysqlPessoaDao.updatePessoa \n " + ex.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
            }
        }
    }

    public Pessoa selectPessoa(String id) {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = MysqlDAOFactory.ConnectDb();
            ps = conn.prepareStatement("SELECT nome FROM pessoa WHERE id_user = ?");
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                pessoa = new Pessoa();
                pessoa.setNome(rs.getString("nome"));
            }
            return pessoa;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no MysqlPessoaDao.selectAllPessoa \n " + ex.getMessage());
            return null;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
            }
        }
    }

    public Pessoa verificarAcesso(String user, String pass) {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = MysqlDAOFactory.ConnectDb();
            ps = conn.prepareStatement("SELECT nome, tipo_usuario FROM pessoa WHERE nome = ? AND senha = ?");
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                pessoa = new Pessoa();
                pessoa.setNome(rs.getString("nome"));
                pessoa.setTipo(rs.getString("tipo_usuario"));
            }
            return pessoa;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no MysqlPessoaDao.selectAllPessoa \n " + ex.getMessage());
            return null;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
            }
        }
    }

    @Override
    public List<Pessoa> selectAllPessoa() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Pessoa pessoa = null;
        List<Pessoa> lista = new ArrayList();
        try {

            conn = MysqlDAOFactory.ConnectDb();
            ps = conn.prepareStatement("Select * from pessoa");
            rs = ps.executeQuery();

            while (rs.next()) {
                pessoa = new Pessoa();
                //String id = rs.getString("id_user");
                pessoa.setNome(rs.getString("nome"));
                pessoa.setSenha(rs.getString("senha"));
                pessoa.setTipo(rs.getString("tipo_usuario"));
                pessoa.setId(rs.getString("id_user"));
                lista.add(pessoa);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no MysqlPessoaDao.selectAllPessoa \n " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
            }
        }
        return lista;
    }

}
