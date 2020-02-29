package ee.coolLibrary.services;

import ee.coolLibrary.entities.SimpleEntity;
import ee.coolLibrary.repositories.SimpleRepository;

import java.util.Objects;

public abstract class AbstractService <REPO extends SimpleRepository<ENT, ID>, ENT extends SimpleEntity<ID>, ID> implements SimpleService <ENT, ID> {

    REPO repository;

    public AbstractService(REPO repository) {
        this.repository = repository;
    }


}
