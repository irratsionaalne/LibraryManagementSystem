package ee.coolLibrary.services.contracts;

public interface SimpleService <ENT, ID> {


    ENT save (ENT entity);
    ENT findById (ID id);
    ENT delete (ENT entity);
    ENT update (ENT entity);
    Iterable<ENT> findAll ();



}
