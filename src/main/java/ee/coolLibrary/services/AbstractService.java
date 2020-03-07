package ee.coolLibrary.services;

import ee.coolLibrary.repositories.contracts.SimpleRepository;
import ee.coolLibrary.services.contracts.SimpleService;

public abstract class AbstractService<REPO extends SimpleRepository<ENT, ID>, ENT, ID> implements SimpleService<ENT, ID> {

    REPO repository;

    public AbstractService(REPO repository) {
        this.repository = repository;
    }


}
