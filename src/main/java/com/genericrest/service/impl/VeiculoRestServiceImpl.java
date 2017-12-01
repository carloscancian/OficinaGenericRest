package com.genericrest.service.impl;

import com.genericrest.dao.DAO;
import com.genericrest.dao.VeiculoDAO;
import com.genericrest.model.Veiculo;
import com.genericrest.service.GenericCRUDRestService;
import com.genericrest.service.VeiculoRestService;
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

@Path("/veiculo")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class VeiculoRestServiceImpl extends GenericCRUDRestService<Veiculo> implements VeiculoRestService{

    private static final Logger log = LoggerFactory.getLogger(VeiculoRestServiceImpl.class);
    
    @Inject
    private VeiculoDAO veiculoDAO;
    
    public VeiculoRestServiceImpl() {
        super(Veiculo.class);
    }

    @Override
    public GenericEntity listToGenericEntity(List<Veiculo> list) {
       return new GenericEntity<List<Veiculo>>(list){};
    }

    @Override
    public DAO getDao() {
      return veiculoDAO;
    }

    @Override
    public Logger getLogger() {
       return log; 
    }
    
}
