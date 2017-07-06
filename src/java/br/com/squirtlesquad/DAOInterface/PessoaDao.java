package br.com.squirtlesquad.DAOInterface;

import java.util.List;

import br.com.squirtlesquad.obj.Pessoa;

public interface PessoaDao {

    public void insertPessoa(Pessoa pessoa);

    public void removePessoa(String id);

    public void updatePessoa(Pessoa pessoa, String id);

    public Object selectPessoa(String id);

    public List<Pessoa> selectAllPessoa();

}
