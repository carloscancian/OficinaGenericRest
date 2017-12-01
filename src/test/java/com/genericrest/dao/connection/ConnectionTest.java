package com.genericrest.dao.connection;

import javax.persistence.EntityManager;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author fernando
 */
public class ConnectionTest {
    
    private final DatabaseConnection connection;
    
    public ConnectionTest() {
        connection = DatabaseConnection.newInstance();
    }
    
    @Test
    public void hasValidConnection() {
        Assert.assertNotNull(connection);
        
        EntityManager entityManager = connection.getEntityManager();
        Assert.assertNotNull(entityManager);
        Assert.assertTrue(entityManager.isOpen());
    }
}
