package com.genericrest.dao;

import com.genericrest.model.AbstractEntity;
import java.util.List;
import javax.persistence.EntityManager;
import org.slf4j.Logger;

/**
 *
 * @author fernando
 * @param <T> EntityClass to manage
 * @param <K> Datatype from ID
 */
public interface DAO<T extends AbstractEntity, K> {

    void save(T entity);

    void update(T entity);

    void delete(T entity);

    T merge(T entity);

    T findById(K id);

    List<T> findAll();

    void deleteAll();
    
    EntityManager getEntityManager();

    Class<T> getEntityClass();
    
    Logger getLogger();
}
