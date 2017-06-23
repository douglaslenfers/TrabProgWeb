/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private Pessoa tipoPessoa;

    public MysqlPessoaDao() {
        conn = MysqlDAOFactory.ConnectDb();

    }

    @Override
    public void insertPessoa(Pessoa pessoa) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = MysqlDAOFactory.ConnectDb();
            ps = conn.prepareStatement("INSERT INTO pessoa (nome, id_pessoa) VALUES (?, ?)");
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getId());
            ps.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no SqlitePessoaDao.insertPessoa \n " + ex.getMessage());
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
    public void removePessoa(String matricula) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = MysqlDAOFactory.ConnectDb();
            ps = conn.prepareStatement("DELETE FROM pessoa WHERE id_pessoa = ?");
            ps.setString(1, matricula);
            ps.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no SqlitePessoaDao.removePessoa \n " + ex.getMessage());
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
    public void updatePessoa(Pessoa pessoa, String matricula) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = MysqlDAOFactory.ConnectDb();
            ps = conn.prepareStatement("UPDATE pessoa SET nome = ?, id_pessoa = ? WHERE id_pessoa = ?");
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getId());
            ps.setString(3, matricula);
            ps.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no SqlitePessoaDao.updatePessoa \n " + ex.getMessage());
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
    public int getIdPessoa(String matricula) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int idRetornado = 0;
        try {
            conn = MysqlDAOFactory.ConnectDb();
            ps = conn.prepareStatement("SELECT id_pessoa FROM pessoa WHERE id_pessoa = ?");
            ps.setString(1, matricula);
            rs = ps.executeQuery();
            idRetornado = rs.getInt("id_pessoa");
            return idRetornado;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no SqlitPessoaDao.selectPessoa \n " + ex.getMessage());
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
        return idRetornado;
    }

    public Pessoa selectPessoaFromId(String matricula) {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;
        tipoPessoa = null;
        try {
            conn = MysqlDAOFactory.ConnectDb();
            ps = conn.prepareStatement("SELECT nome, id_pessoa FROM pessoa WHERE id_pessoa = ?");
            ps.setString(1, matricula);
            rs = ps.executeQuery();
            tipoPessoa.setId(matricula);
            tipoPessoa.setNome(rs.getString("nome"));

            return tipoPessoa;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no SqliteLivroDao.selectLivro \n " + ex.getMessage());
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
	public Object selectPessoa(String matricula, Pessoa tipoPessoa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertAllPessoa(List<Pessoa> pessoas) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Pessoa> selectAllPessoa() {
		// TODO Auto-generated method stub
		return null;
	}


}
