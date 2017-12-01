package com.genericrest.dao.impl;

import com.genericrest.dao.ControlePecaDAO;
import com.genericrest.dao.GenericDAO;
import com.genericrest.model.ControlePeca;
import javax.enterprise.context.ApplicationScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author carlos
 */
@ApplicationScoped
public class ControlePecaDAOImpl extends GenericDAO<ControlePeca, Long> implements ControlePecaDAO {

    private static final Logger log = LoggerFactory.getLogger(ControlePecaDAOImpl.class);

    public ControlePecaDAOImpl() {
        super(ControlePeca.class);
    }

    @Override
    public Logger getLogger() {
        return log;
    }

}
