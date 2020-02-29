package ee.coolLibrary.repositories;

public interface SimpleRepository <ENT, ID> {
    ENT save (ENT entity);
    ENT findById (Class<ENT> entClass, ID id);
    ENT delete (ENT entity);
    ENT update (ENT entity);
    Iterable<ENT> findAll ();
}
