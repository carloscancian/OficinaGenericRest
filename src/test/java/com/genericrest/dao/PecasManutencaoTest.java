package com.genericrest.dao;

import com.genericrest.dao.impl.ControlePecaDAOImpl;
import com.genericrest.dao.impl.ManutencaoDAOImpl;
import com.genericrest.dao.impl.PecasManutencaoDAOImpl;
import com.genericrest.model.PecasManutencao;
import com.genericrest.model.ControlePeca;
import com.genericrest.model.Manutencao;
import java.util.List;
import javax.inject.Inject;
import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

/**
 *
 * @author Carlos
 */
@RunWith(CdiRunner.class)
@AdditionalClasses({PecasManutencaoDAOImpl.class,ControlePecaDAOImpl.class,ManutencaoDAOImpl.class})
public class PecasManutencaoTest {

    @Inject
    private PecasManutencaoDAO pecasManutencaoDAO;
     
    @Inject
    private ControlePecaDAO controlePecaDAO;
    
    @Inject
    private ManutencaoDAO manutencaoDAO;

    @Test
    public void testeInjecao() {
        assertNotNull(pecasManutencaoDAO);
        assertNotNull(controlePecaDAO);
        assertNotNull(manutencaoDAO);
    }

    @Test
    public void insercao() {
        List<PecasManutencao> pecasManutencao = pecasManutencaoDAO.findAll();
        List<ControlePeca> controlePecas = controlePecaDAO.findAll();
        List<Manutencao> manutencoes = manutencaoDAO.findAll();

        if (pecasManutencao == null || pecasManutencao.isEmpty()) {
            
            PecasManutencao pecasmanutencao = new PecasManutencao(manutencoes.get(0), controlePecas.get(0));
            pecasManutencaoDAO.save(pecasmanutencao);

            pecasManutencao = pecasManutencaoDAO.findAll();
            assertNotNull(pecasManutencao);
            assertFalse(pecasManutencao.isEmpty());
        }
    }
    
}
