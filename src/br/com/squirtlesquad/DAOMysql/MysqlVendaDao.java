package br.com.squirtlesquad.DAOMysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.JOptionPane;

import br.com.squirtlesquad.DAOInterface.VendaDao;
import br.com.squirtlesquad.obj.Pessoa;
import br.com.squirtlesquad.obj.Produto;
import br.com.squirtlesquad.obj.Venda;

public class MysqlVendaDao implements VendaDao{

	Connection conn = null;
	PreparedStatement ps = null;
	private Venda venda;

	public MysqlVendaDao() {
		conn = MysqlDAOFactory.ConnectDb();
	}
	
	@Override
	public void insertVenda(Venda venda) {
		Connection conn = null;
		PreparedStatement ps = null;
		//MysqlProdutoDao produtoDao = new MysqlProdutoDao();
		
		try {
			for(Produto p : venda.getProduto()){
				System.out.println(p.getId());
				conn = MysqlDAOFactory.ConnectDb();
				ps = conn.prepareStatement(
						"INSERT INTO venda (idvenda, idproduto, idfuncionario, dtvenda) VALUES (?, ?, ?, ?)");
				ps.setInt(1, venda.getIdVenda());
				ps.setInt(2, p.getId());
				ps.setString(3, venda.getPessoa().getId());		
				ps.setDate(4, new java.sql.Date(venda.getDataVenda().getTime()));
				ps.execute();
			}
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro no MysqlVendaDao.insertVenda \n " + ex.getMessage());
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
	public void removeVenda(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = MysqlDAOFactory.ConnectDb();
			ps = conn.prepareStatement("DELETE FROM venda WHERE idvenda= ?");
			ps.setString(1, id);
			ps.execute();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro no MysqlVendaDao.removeVenda \n " + ex.getMessage());
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
	public Object selectVenda(String id) {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement ps = null;
		Venda venda = null;
		try {
			conn = MysqlDAOFactory.ConnectDb();
			ps = conn.prepareStatement(
					"SELECT idvenda, idproduto, idfuncionario, dtvenda FROM venda WHERE idvenda = ?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				
				venda = new Venda();
				venda.setIdVenda(rs.getInt("idvenda"));
				
				MysqlPessoaDao pessoaDao = new MysqlPessoaDao();
				Pessoa pessoa = new Pessoa();
				pessoa = pessoaDao.selectPessoa(rs.getString("idvenda"));
				venda.setPessoa(pessoa);
				
				MysqlProdutoDao produtoDao = new MysqlProdutoDao();
				Produto produto = new Produto();
				produto = produtoDao.selectProduto(rs.getString("idproduto"));
				venda.addProduto(produto);
				
				venda.setDataVenda(rs.getDate("dtvenda"));
			}
			return venda;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro no MysqlVendaDao.selectVenda \n " + ex.getMessage());
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
	

	
	
}
