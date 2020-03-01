package ee.coolLibrary.repositories.contracts;

public interface SimpleRepository <ENT, ID> {
    ENT save (ENT entity);
    ENT findById (ID id);
    ENT delete (ENT entity);
    ENT update (ENT entity);
    Iterable<ENT> findAll ();
}
