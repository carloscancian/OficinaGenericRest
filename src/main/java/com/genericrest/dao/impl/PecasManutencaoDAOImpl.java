package com.genericrest.dao.impl;

import com.genericrest.dao.GenericDAO;
import com.genericrest.dao.PecasManutencaoDAO;
import com.genericrest.model.PecasManutencao;
import javax.enterprise.context.ApplicationScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author carlos
 */
@ApplicationScoped
public class PecasManutencaoDAOImpl extends GenericDAO<PecasManutencao, Long> implements PecasManutencaoDAO {

    private static final Logger log = LoggerFactory.getLogger(PecasManutencaoDAOImpl.class);

    public PecasManutencaoDAOImpl() {
        super(PecasManutencao.class);
    }

    @Override
    public Logger getLogger() {
        return log;
    }

}
