package com.genericrest.dao;

import com.genericrest.dao.impl.ClienteDAOImpl;
import com.genericrest.dao.impl.VeiculoDAOImpl;
import com.genericrest.model.Cliente;
import com.genericrest.model.Veiculo;
import java.util.List;
import javax.inject.Inject;
import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

/**
 *
 * @author carlos
 */
@RunWith(CdiRunner.class)
@AdditionalClasses({VeiculoDAOImpl.class,ClienteDAOImpl.class})
public class VeiculoTest {

    @Inject
    private VeiculoDAO veiculoDAO;
    
    @Inject
    private ClienteDAO clienteDAO;

    @Test
    public void testeInjecao() {
        assertNotNull(veiculoDAO);
        assertNotNull(clienteDAO);
    }

    @Test
    public void insercao() {
        List<Veiculo> veiculos = veiculoDAO.findAll();
        List<Cliente> clientes = clienteDAO.findAll();

        if (veiculos == null || veiculos.isEmpty()) {
            
            Veiculo veiculo = new Veiculo(1, "teste", 982, "teste", "AAA-0000", clientes.get(0));
            veiculoDAO.save(veiculo);

            veiculos = veiculoDAO.findAll();
            assertNotNull(veiculos);
            assertFalse(veiculos.isEmpty());
        }
    }

}
