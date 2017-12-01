package com.genericrest.dao;

import com.genericrest.dao.impl.ControlePecaDAOImpl;
import com.genericrest.model.ControlePeca;
import java.util.List;
import javax.inject.Inject;
import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author carlos
 */
@RunWith(CdiRunner.class)
@AdditionalClasses({ControlePecaDAOImpl.class})
public class ControlePecaTest {
    
    @Inject
    private ControlePecaDAO controlePecaDAO;

    @Test
    public void testeInjecao() {
        assertNotNull(controlePecaDAO);
    }

    @Test
    public void insercao() {
        List<ControlePeca> controlepecas = controlePecaDAO.findAll();


        if (controlepecas == null || controlepecas.isEmpty()) {
            
            ControlePeca controlepeca = new ControlePeca(1, "teste", "teste", 1);
            controlePecaDAO.save(controlepeca);

            controlepecas = controlePecaDAO.findAll();
            assertNotNull(controlepecas);
            assertFalse(controlepecas.isEmpty());
        }
    }
   
}
