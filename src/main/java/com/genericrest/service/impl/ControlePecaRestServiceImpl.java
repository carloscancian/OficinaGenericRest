package com.genericrest.service.impl;

import com.genericrest.dao.ControlePecaDAO;
import com.genericrest.dao.DAO;
import com.genericrest.model.ControlePeca;
import com.genericrest.model.Veiculo;
import com.genericrest.service.ControlePecaRestService;
import com.genericrest.service.GenericCRUDRestService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author carlos
 */
@Path("/controlepeca")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class ControlePecaRestServiceImpl extends GenericCRUDRestService<ControlePeca> implements ControlePecaRestService{

    private static final Logger log = LoggerFactory.getLogger(ControlePecaRestServiceImpl.class);
    
    @Inject
    private ControlePecaDAO controlePecaDAO;
    
    public ControlePecaRestServiceImpl() {
        super(ControlePeca.class);
    }

    @Override
    public GenericEntity listToGenericEntity(List<ControlePeca> list) {
       return new GenericEntity<List<ControlePeca>>(list){};
    }

    @Override
    public DAO getDao() {
       return controlePecaDAO;
    }

    @Override
    public Logger getLogger() {
       return log;
    }
    
}
