package ee.coolLibrary.repositories;

public interface SimpleRepository <ENT, ID> {
    ENT save (ENT entity);
    ENT findById (ID id);
    Iterable<ENT> findAll ();
}
