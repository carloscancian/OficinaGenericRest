package com.genericrest.service.impl;

import com.genericrest.dao.ClienteDAO;
import com.genericrest.dao.DAO;
import com.genericrest.model.Cliente;
import com.genericrest.service.ClienteRestService;
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
@Path("/cliente")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class ClienteRestServiceImpl extends GenericCRUDRestService<Cliente> implements ClienteRestService{

    private static final Logger log = LoggerFactory.getLogger(ClienteRestServiceImpl.class);
    
    @Inject
    private ClienteDAO clienteDAO;
    
    
    public ClienteRestServiceImpl() {
        super(Cliente.class);
    }

    @Override
    public GenericEntity listToGenericEntity(List<Cliente> list) {
       return new GenericEntity<List<Cliente>>(list){}; 
    }

    @Override
    public DAO getDao() {
       return clienteDAO;
    }

    @Override
    public Logger getLogger() {
       return log; 
    }
    
}
