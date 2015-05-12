package de.fau.cs.mad.fablab.rest.server.resources;

import de.fau.cs.mad.fablab.rest.server.core.News;

import de.fau.cs.mad.fablab.rest.server.core.NewsDAO;
import de.fau.cs.mad.fablab.rest.server.core.NewsApi;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


/**
 * Created by EE on 11.05.15.
 */
@Path("/news")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NewsResource implements NewsApi {

    private final NewsDAO dao;
    public NewsResource(NewsDAO dao) {
        this.dao = dao;
    }

    @GET
    @UnitOfWork
    @Path("/{id}")
    @Override
    public News findById(@PathParam("id")long id) {
        return  dao.findById(id);
    }

    @GET
    @UnitOfWork
    @Override
    public List<News> findAll() {
        return dao.findAll();
    }

    @POST
    @UnitOfWork
    @Override
    public News create(News news) {
        return dao.create(news);
    }


    @PUT
    @UnitOfWork
    @Override
    public News update(News news) {
        return dao.update(news);
    }

    @DELETE
    @UnitOfWork
    @Path("/{id}")
    @Override
    public void delete(@PathParam("id") long id) {
        dao.delete(id);
    }

    @DELETE
    @UnitOfWork
    @Override
    public void deleteAll() {
        dao.deleteAll();
    }
}