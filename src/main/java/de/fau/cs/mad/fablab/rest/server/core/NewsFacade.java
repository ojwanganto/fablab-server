package de.fau.cs.mad.fablab.rest.server.core;
import de.fau.cs.mad.fablab.rest.core.News;
import de.fau.cs.mad.fablab.rest.server.core.drupal.NewsClient;
import de.fau.cs.mad.fablab.rest.server.core.drupal.NewsFeedClient;
import de.fau.cs.mad.fablab.rest.server.core.drupal.NewsInterface;

import java.util.Date;
import java.util.List;

public class NewsFacade {

    private final NewsDAO dao;
    private final NewsInterface newsInterface;

    public NewsFacade(NewsDAO dao) {
        this.dao = dao;
        this.newsInterface = NewsFeedClient.getInstance();
    }

    public News findById(Long id) {
        //return this.dao.findById(id);
        return newsInterface.findById(id);
    }

    public List<News> findAll(){
        //return this.dao.findAll();
        return newsInterface.findAll();
    }

    public List<News> find(int offset, int limit) {
        //return this.dao.find(offset, limit);
        return newsInterface.find(offset, limit);
    }

    public List<News> findNewsSince(long timestamp) {
        return newsInterface.findNewsSince(timestamp);
    }

    public long lastUpdate() {
        return newsInterface.lastUpdate();
    }

    public News create(News obj) {
        return this.dao.create(obj);
    }

}
