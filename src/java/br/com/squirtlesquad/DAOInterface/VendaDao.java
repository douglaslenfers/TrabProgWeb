package br.com.squirtlesquad.DAOInterface;

import br.com.squirtlesquad.obj.Venda;

public interface VendaDao {

    public void insertVenda(Venda venda);

    public void removeVenda(String id);

    public Object selectVenda(String id);

}
