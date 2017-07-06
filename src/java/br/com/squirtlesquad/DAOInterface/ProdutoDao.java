package br.com.squirtlesquad.DAOInterface;

import java.util.List;

import br.com.squirtlesquad.obj.Produto;

public interface ProdutoDao {

    public void insertProduto(Produto produto);

    public void removeProduto(String id);

    public void updateProduto(Produto produto, String id);

    public Object selectProduto(String id);

    public List<Produto> selectAllProduto();
}
