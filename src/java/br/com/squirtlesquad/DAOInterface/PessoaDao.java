/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
