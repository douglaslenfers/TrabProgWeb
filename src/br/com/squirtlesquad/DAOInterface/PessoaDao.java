/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.squirtlesquad.DAOInterface;

import java.util.List;

import br.com.squirtlesquad.obj.Pessoa;


/**
 *
 * @author Hiroshi
 */
public interface PessoaDao {

    public void insertPessoa(Pessoa pessoa);

    public void removePessoa(String matricula);

    public void updatePessoa(Pessoa pessoa, String matricula);

    public int getIdPessoa(String matricula);

    public Object selectPessoa(String matricula, Pessoa tipoPessoa);
    
    public void insertAllPessoa(List<Pessoa> pessoas);
    
    public List<Pessoa> selectAllPessoa();
    

    
}
