package ee.coolLibrary.repositories;

public interface SimpleRepository <ENT, ID> {
    ENT save (ENT entity);
    ENT findById (ENT entity, ID id);
    ENT delete (ENT entity);
    ENT update (ENT entity);
    Iterable<ENT> findAll ();
}
