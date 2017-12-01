package com.genericrest.dao.impl;

import com.genericrest.dao.GenericDAO;
import com.genericrest.dao.VeiculoDAO;
import com.genericrest.model.Veiculo;
import javax.enterprise.context.ApplicationScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author carlos
 */
@ApplicationScoped
public class VeiculoDAOImpl extends GenericDAO<Veiculo, Long> implements VeiculoDAO {

    private static final Logger log = LoggerFactory.getLogger(VeiculoDAOImpl.class);

    public VeiculoDAOImpl() {
        super(Veiculo.class);
    }

    @Override
    public Logger getLogger() {
        return log;
    }

}
