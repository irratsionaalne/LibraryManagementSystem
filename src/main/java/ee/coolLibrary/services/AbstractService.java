package ee.coolLibrary.services;

import ee.coolLibrary.entities.SimpleEntity;
import ee.coolLibrary.repositories.SimpleRepository;

public class AbstractService <REPO extends SimpleRepository<ENT, ID>, ENT extends SimpleEntity<ID>, ID> implements SimpleService <ENT, ID> {

    REPO repository;

    public AbstractService(REPO repository) {
        this.repository = repository;
    }

    @Override
    public ENT save(ENT entity) {
        return repository.save(entity);
    }

    @Override
    public ENT findById(ID id) {
        return repository.findById(ENT, id);
    }

    @Override
    public ENT delete(ENT entity) {
        return null;
    }

    @Override
    public ENT update(ENT entity) {
        return null;
    }

    @Override
    public Iterable<ENT> findAll() {
        return null;
    }
}
