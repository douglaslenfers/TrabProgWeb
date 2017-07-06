package br.com.squirtlesquad.DAOFactory;

import br.com.squirtlesquad.DAOInterface.PessoaDao;
import br.com.squirtlesquad.DAOMysql.MysqlDAOFactory;
import objeto.TipoFonte;

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
