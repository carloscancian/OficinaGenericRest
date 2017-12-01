package com.genericrest.dao;

import com.genericrest.dao.impl.ClienteDAOImpl;
import com.genericrest.model.Cliente;
import java.util.Date;
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
@AdditionalClasses({ClienteDAOImpl.class})
public class ClienteTest {

    @Inject
    private ClienteDAO clienteDAO;

    @Test
    public void testeInjecao() {
        assertNotNull(clienteDAO);
    }

    @Test
    public void insercao() {
        List<Cliente> clientes = clienteDAO.findAll();

        if (clientes == null || clientes.isEmpty()) {
            Cliente cliente = new Cliente(1, "teste", "teste", "0000-000", new Date());
            clienteDAO.save(cliente);

            clientes = clienteDAO.findAll();
            assertNotNull(clientes);
            assertFalse(clientes.isEmpty());
        }
    }

}
