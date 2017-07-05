package br.com.squirtlesquad.DAOMysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.squirtlesquad.DAOInterface.ProdutoDao;
import br.com.squirtlesquad.obj.Pessoa;
import br.com.squirtlesquad.obj.Produto;

public class MysqlProdutoDao implements ProdutoDao {

	Connection conn = null;
	PreparedStatement ps = null;
	private Produto produto;

	public MysqlProdutoDao() {
		conn = MysqlDAOFactory.ConnectDb();

	}

	@Override
	public void insertProduto(Produto produto) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = MysqlDAOFactory.ConnectDb();
			ps = conn.prepareStatement(
					"INSERT INTO produto (idproduto, nome, descricao, quantidade, valor_unidade, validade, imagem, is_promocao, porcentagem_promocao, qtd_minima_desconto, unidade_medida) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, produto.getId());
			ps.setString(2, produto.getNome());
			ps.setString(3, produto.getDescricao());
			ps.setInt(4, produto.getQuantidade());
			ps.setDouble(5, produto.getValorUnidade());
			ps.setDate(6, new java.sql.Date(produto.getDataValidade().getTime()));
			ps.setString(7, produto.getCaminhoImagem());
			ps.setInt(8, produto.getPromocao());
			ps.setDouble(9, produto.getPorcentagemPromocao());
			ps.setInt(10, produto.getQuantidadeMinDesconto());
			ps.setString(11, produto.getUnidadeMedida());

			ps.execute();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro no MysqlProdutoDao.insertProduto \n " + ex.getMessage());
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
	public void removeProduto(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = MysqlDAOFactory.ConnectDb();
			ps = conn.prepareStatement("DELETE FROM Produto WHERE idproduto = ?");
			ps.setString(1, id);
			ps.execute();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro no MysqlProdutoDao.removeProduto \n " + ex.getMessage());
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
	public void updateProduto(Produto produto, String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = MysqlDAOFactory.ConnectDb();
			ps = conn.prepareStatement(
					"UPDATE produto SET idproduto = ?, nome = ?, descricao = ?, quantidade = ?, valor_unidade = ?, validade = ?, imagem = ?, is_promocao = ?, porcentagem_promocao = ?, qtd_minima_desconto = ?, unidade_medida = ?  WHERE idproduto = ?");
			ps.setInt(1, produto.getId());
			ps.setString(2, produto.getNome());
			ps.setString(3, produto.getDescricao());
			ps.setInt(4, produto.getQuantidade());
			ps.setDouble(5, produto.getValorUnidade());
			ps.setDate(6, new java.sql.Date(produto.getDataValidade().getTime()));
			ps.setString(7, produto.getCaminhoImagem());
			ps.setInt(8, produto.getPromocao());
			ps.setDouble(9, produto.getPorcentagemPromocao());
			ps.setInt(10, produto.getQuantidadeMinDesconto());
			ps.setString(11, produto.getUnidadeMedida());
			ps.setString(12, id);
			ps.execute();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro no MysqlProdutoDao.updateProduto \n " + ex.getMessage());
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
	public Produto selectProduto(String id) {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = MysqlDAOFactory.ConnectDb();
			ps = conn.prepareStatement(
					"SELECT idproduto, nome, quantidade, valor_unidade, validade, imagem, is_promocao, porcentagem_promocao, qtd_minima_desconto, descricao FROM produto WHERE idproduto = ?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				produto = new Produto();
				produto.setNome(rs.getString("nome"));
				produto.setId(rs.getInt("idproduto"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setValorUnidade(rs.getDouble("valor_unidade"));
				produto.setCaminhoImagem(rs.getString("imagem"));
				produto.setPromocao(rs.getInt("is_promocao"));
				produto.setPorcentagemPromocao(rs.getDouble("porcentagem_promocao"));
				produto.setQuantidadeMinDesconto(rs.getInt("qtd_minima_desconto"));
				produto.setDataValidade(rs.getDate("validade"));
			}
			return produto;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro no MysqlProdutoDao.selectProduto \n " + ex.getMessage());
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
	
	public Object selectProdutoId(String nome) {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement ps = null;
		int idProduto = -1;
		try {
			conn = MysqlDAOFactory.ConnectDb();
			ps = conn.prepareStatement(
					"SELECT idproduto FROM produto WHERE nome = ?");
			ps.setString(1, nome);
			rs = ps.executeQuery();
			while (rs.next()) {
				idProduto = rs.getInt("idproduto");
			}
			return idProduto;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro no MysqlProdutoDao.selectProduto \n " + ex.getMessage());
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
	public List<Produto> selectAllProduto() {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Produto produto = null;
		List<Produto> lista = new ArrayList();
		try {

			conn = MysqlDAOFactory.ConnectDb();
			ps = conn.prepareStatement("Select * from produto");
			rs = ps.executeQuery();

			while (rs.next()) {
				produto = new Produto();
				produto.setNome(rs.getString("nome"));
				produto.setId(rs.getInt("idproduto"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setValorUnidade(rs.getDouble("valor_unidade"));
				produto.setCaminhoImagem(rs.getString("imagem"));
				produto.setPromocao(rs.getInt("is_promocao"));
				produto.setPorcentagemPromocao(rs.getDouble("porcentagem_promocao"));
				produto.setQuantidadeMinDesconto(rs.getInt("qtd_minima_desconto"));
				produto.setDataValidade(rs.getDate("validade"));
				lista.add(produto);
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro no MysqlProdutoDao.selectAllProduto \n " + ex.getMessage());
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
