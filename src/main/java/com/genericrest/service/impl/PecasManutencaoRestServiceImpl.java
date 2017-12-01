package com.genericrest.service.impl;

import com.genericrest.dao.DAO;
import com.genericrest.dao.PecasManutencaoDAO;
import com.genericrest.model.PecasManutencao;
import com.genericrest.model.Veiculo;
import com.genericrest.service.GenericCRUDRestService;
import com.genericrest.service.PecasManutencaoRestService;
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
@Path("/pecasmanutencao")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class PecasManutencaoRestServiceImpl extends GenericCRUDRestService<PecasManutencao> implements PecasManutencaoRestService {

    private static final Logger log = LoggerFactory.getLogger(PecasManutencaoRestServiceImpl.class);

    @Inject
    private PecasManutencaoDAO pecasManutencaoDAO;

    public PecasManutencaoRestServiceImpl() {
        super(PecasManutencao.class);
    }

    @Override
    public GenericEntity listToGenericEntity(List<PecasManutencao> list) {
        return new GenericEntity<List<PecasManutencao>>(list) {
        };
    }

    @Override
    public DAO getDao() {
        return pecasManutencaoDAO;
    }

    @Override
    public Logger getLogger() {
        return log;
    }

}
