package de.fau.cs.mad.fablab.rest.server;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Configuration class containing environment specific parameters
 * specified in the given YAML file when starting the application
 * The mapping between this class and the used yaml file is done by Jackson
 */
class ServerConfiguration extends Configuration
{
    //the template string of your yaml file
    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName;

    @JsonProperty
    public String getTemplate()
    {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
    public String getDefaultName()
    {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String name) {
        this.defaultName = name;
    }

    @Valid
    @NotNull
    @JsonProperty
    private DataSourceFactory database = new DataSourceFactory();
    public DataSourceFactory getDatabase() {
        return database;
    }
}
