package com.genericrest.dao.impl;

import com.genericrest.dao.GenericDAO;
import com.genericrest.dao.ManutencaoDAO;
import com.genericrest.model.Manutencao;
import javax.enterprise.context.ApplicationScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author carlos
 */
@ApplicationScoped
public class ManutencaoDAOImpl extends GenericDAO<Manutencao, Long> implements ManutencaoDAO {

    private static final Logger log = LoggerFactory.getLogger(ManutencaoDAOImpl.class);

    public ManutencaoDAOImpl() {
        super(Manutencao.class);
    }

    @Override
    public Logger getLogger() {
        return log;
    }

}
