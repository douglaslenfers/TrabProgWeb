/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.squirtlesquad.DAOFactory;


import br.com.squirtlesquad.DAOInterface.PessoaDao;
import br.com.squirtlesquad.DAOMysql.MysqlDAOFactory;
import objeto.TipoFonte;


/**
 *
 * @author Hiroshi
 */
public abstract class DAOFactory {



    public abstract PessoaDao getPessoaDao();



    public static DAOFactory getDAOFactory(TipoFonte opcao) {
        if (TipoFonte.BANCO == opcao) {
            return new MysqlDAOFactory();
        } else {
            return null;
        }
    }
}
