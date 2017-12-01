package com.genericrest.dao;

import com.genericrest.dao.impl.ManutencaoDAOImpl;
import com.genericrest.dao.impl.VeiculoDAOImpl;
import com.genericrest.model.Manutencao;
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
@AdditionalClasses({VeiculoDAOImpl.class,ManutencaoDAOImpl.class})
public class ManutencaoTest {
    
    @Inject
    private ManutencaoDAO manutencaoDAO;
     
    @Inject
    private VeiculoDAO veiculoDAO;

    @Test
    public void testeInjecao() {
        assertNotNull(veiculoDAO);
        assertNotNull(manutencaoDAO);
    }

    @Test
    public void insercao() {
        List<Manutencao> manutencoes = manutencaoDAO.findAll();
        List<Veiculo> veiculos = veiculoDAO.findAll();

        if (manutencoes == null || manutencoes.isEmpty()) {
            
            Manutencao manutencao = new Manutencao(1, "teste", 1, veiculos.get(0));
            manutencaoDAO.save(manutencao);

            manutencoes = manutencaoDAO.findAll();
            assertNotNull(manutencoes);
            assertFalse(manutencoes.isEmpty());
        }
    }
}
