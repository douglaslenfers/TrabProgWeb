package br.com.squirtlesquad.DAOMysql;

import java.sql.Connection;
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
					"INSERT INTO Pessoa (id_produto, nome, desc, quantidade, valor_unidade, validade, imagem, is_promocao, porcentagem_promocao, qtd_minima_desconto) VALUES (?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, produto.getId());
			ps.setString(2, produto.getNome());
			ps.setString(3, produto.getDescricao());
			ps.setInt(4, produto.getQuantidade());
			ps.setDouble(5, produto.getValorUnidade());
			ps.setString(6, produto.getDataValidade());
			ps.setString(7, produto.getCaminhoImagem());
			ps.setInt(8, produto.getPromocao());
			ps.setDouble(9, produto.getPorcentagemPromocao());
			ps.setInt(10, produto.getQuantidadeMinDesconto());

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
			ps = conn.prepareStatement("DELETE FROM Produto WHERE id_produto = ?");
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
					"UPDATE Pessoa SET id_produto = ?, nome = ?, desc = ?, quantidade = ?, valor_unidade = ?, validade = ?, imagem = ?, is_promocao = ?, porcentagem_promocao = ?, qtd_minima_desconto = ?  WHERE id_produto = ?");
			ps.setInt(1, produto.getId());
			ps.setString(2, produto.getNome());
			ps.setString(3, produto.getDescricao());
			ps.setInt(4, produto.getQuantidade());
			ps.setDouble(5, produto.getValorUnidade());
			ps.setString(6, produto.getDataValidade());
			ps.setString(7, produto.getCaminhoImagem());
			ps.setInt(8, produto.getPromocao());
			ps.setDouble(9, produto.getPorcentagemPromocao());
			ps.setInt(10, produto.getQuantidadeMinDesconto());
			ps.setString(11, id);
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
	public Object selectProduto(String id) {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = MysqlDAOFactory.ConnectDb();
			ps = conn.prepareStatement(
					"SELECT id_produto, nome, desc, quantidade, valor_unidade, validade, imagem, is_promocao, porcentagem_promocao, qtd_minima_desconto FROM produto WHERE id_produto = ?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				produto = new Produto();
				produto.setNome(rs.getString("nome"));
				produto.setId(rs.getInt("id_produto"));
				produto.setDescricao(rs.getString("desc"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setValorUnidade(rs.getDouble("valor_unidade"));
				produto.setCaminhoImagem(rs.getString("imagem"));
				produto.setPromocao(rs.getInt("is_promocao"));
				produto.setPorcentagemPromocao(rs.getDouble("porcentagem_promocao"));
				produto.setQuantidadeMinDesconto(rs.getInt("qtd_minima_desconto"));
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
				produto.setId(rs.getInt("id_produto"));
				produto.setDescricao(rs.getString("desc"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setValorUnidade(rs.getDouble("valor_unidade"));
				produto.setCaminhoImagem(rs.getString("imagem"));
				produto.setPromocao(rs.getInt("is_promocao"));
				produto.setPorcentagemPromocao(rs.getDouble("porcentagem_promocao"));
				produto.setQuantidadeMinDesconto(rs.getInt("qtd_minima_desconto"));
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
