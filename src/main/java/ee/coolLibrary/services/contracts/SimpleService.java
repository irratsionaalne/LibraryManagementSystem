package ee.coolLibrary.services.contracts;

import ee.coolLibrary.entities.contracts.SimpleEntity;

public interface SimpleService <ENT extends SimpleEntity<ID>, ID> {


    ENT save (ENT entity);
    ENT findById (ID id);
    ENT delete (ENT entity);
    ENT update (ENT entity);
    Iterable<ENT> findAll ();



}
