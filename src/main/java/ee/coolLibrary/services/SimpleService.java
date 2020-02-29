package ee.coolLibrary.services;

import ee.coolLibrary.entities.SimpleEntity;
import ee.coolLibrary.repositories.SimpleRepository;

public interface SimpleService <ENT extends SimpleEntity<ID>, ID> {


    ENT save (ENT entity);
    ENT findById (ID id);
    ENT delete (ENT entity);
    ENT update (ENT entity);
    Iterable<ENT> findAll ();



}
