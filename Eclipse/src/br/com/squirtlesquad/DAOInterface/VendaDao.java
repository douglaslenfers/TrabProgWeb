package br.com.squirtlesquad.DAOInterface;

import java.util.List;

import br.com.squirtlesquad.obj.Venda;

public interface VendaDao {
    public void insertVenda(Venda venda);

    public void removeVenda(String id);

   // public void updateVenda(Venda venda, String id);

    public Object selectVenda(String id);
    
   // public List<Venda> selectAllVenda();
}
