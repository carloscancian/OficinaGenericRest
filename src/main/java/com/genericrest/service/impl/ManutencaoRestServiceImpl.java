package com.genericrest.service.impl;

import com.genericrest.dao.DAO;
import com.genericrest.dao.ManutencaoDAO;
import com.genericrest.model.Manutencao;
import com.genericrest.service.GenericCRUDRestService;
import com.genericrest.service.ManutencaoRestService;
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
@Path("/manutencao")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class ManutencaoRestServiceImpl extends GenericCRUDRestService<Manutencao> implements ManutencaoRestService{

    private static final Logger log = LoggerFactory.getLogger(ManutencaoRestServiceImpl.class);
    
    @Inject
    private ManutencaoDAO manutencaoDAO;
    
    public ManutencaoRestServiceImpl() {
        super(Manutencao.class);
    }

    @Override
    public GenericEntity listToGenericEntity(List<Manutencao> list) {
       return new GenericEntity<List<Manutencao>>(list){};
    }

    @Override
    public DAO getDao() {
       return manutencaoDAO;
    }

    @Override
    public Logger getLogger() {
       return log;
    }
    
}
