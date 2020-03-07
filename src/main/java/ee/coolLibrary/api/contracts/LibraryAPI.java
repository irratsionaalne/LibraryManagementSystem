package ee.coolLibrary.api.contracts;

import java.util.Set;

public interface LibraryAPI <DTO> {
    DTO save(DTO dto);
    DTO findById (DTO dto);
    DTO delete (DTO dto);
    DTO update (DTO dto);
    DTO findAll ();
}
