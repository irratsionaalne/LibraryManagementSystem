package ee.coolLibrary.services.contracts;

import java.util.Set;

public interface SimpleService <ENT, ID> {

    ENT save(ENT entity);
    ENT findById (ID id);
    ENT delete (ENT entity);
    ENT update (ENT entity);
    Set<ENT> findAll ();

}
