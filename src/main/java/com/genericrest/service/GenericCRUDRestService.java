package com.genericrest.service;

import com.genericrest.model.AbstractEntity;
import java.io.Serializable;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author fernando
 * @param <T>
 */
public abstract class GenericCRUDRestService<T extends AbstractEntity> implements Serializable, CRUDRestService<T> {

    private final Class<T> entityClass;

    public GenericCRUDRestService(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @GET
    @Path("/{param}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public Response getById(@PathParam("param") Long id) {
        getLogger().debug("Search {} object by ID: {}", entityClass.getSimpleName(), id);
        T object = (T) getDao().findById(id);
        if (object == null) {
            return Response.noContent().build();
        }
        return Response.ok().entity(object).build();
    }

    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public Response getAll() {
        getLogger().debug("Search all {} objects.", entityClass.getSimpleName());
        List<T> objects = getDao().findAll();
        if (objects == null || objects.isEmpty()) {
            return Response.noContent().build();
        }
        return Response.ok(listToGenericEntity(objects)).build();
    }

    @POST
    @Path("/save")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public Response save(T entity) {
        getLogger().debug("Save {} object: {}", entityClass.getSimpleName(), entity);
        try {
            entity = (T) getDao().merge(entity);
            return Response.ok().entity(entity).build();
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
    }

    @PUT
    @Path("/update/{param}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public Response update(T entity, @PathParam("param") Long id) {
        getLogger().debug("Update {} object: {}", entityClass.getSimpleName(), entity);
        T found = (T) getDao().findById(id);
        if (found == null) {
            return Response.noContent().build();
        }
        found.updateParameters(entity);
        found = (T) getDao().merge(found);
        return Response.ok().entity(found).build();
    }

    @DELETE 
    @Path("/delete/{param}")
    @Override
    public Response delete(@PathParam("param") Long id) {
        getLogger().debug("Delete {} object by id: {}", entityClass.getSimpleName(), id);
        T found = (T) getDao().findById(id);
        if(found == null) {
            return Response.noContent().build();
        }
        try {
            getDao().delete(found);
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
    }

}
