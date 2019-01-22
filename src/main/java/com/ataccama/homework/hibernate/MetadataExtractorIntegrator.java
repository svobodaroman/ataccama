package com.ataccama.homework.hibernate;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.model.relational.Database;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;
import org.springframework.stereotype.Component;

/**
 * @author Roman Svoboda
 */
@Component
public class MetadataExtractorIntegrator
        implements org.hibernate.integrator.spi.Integrator {

    public static final MetadataExtractorIntegrator INSTANCE =
            new MetadataExtractorIntegrator();

    private Database database;

    private Metadata metadata;

    public Metadata getMetadata() {
        return metadata;
    }

    public Database getDatabase() {
        return database;
    }

    @Override
    public void integrate(
            Metadata metadata,
            SessionFactoryImplementor sessionFactory,
            SessionFactoryServiceRegistry serviceRegistry) {

        database = metadata.getDatabase();
        this.metadata = metadata;
    }

    @Override
    public void disintegrate(
            SessionFactoryImplementor sessionFactory,
            SessionFactoryServiceRegistry serviceRegistry) {
    }
}
