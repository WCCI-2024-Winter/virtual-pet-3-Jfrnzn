package org.wecancodeit.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.Models.ShelterModel;

public interface ShelterRepository extends CrudRepository<ShelterModel, Long> {

    /**
     * @param name
     * @return
     */
    Iterable<ShelterModel> findByName(String name);
    /**
     * 
     * @param zip
     * @return
     */
    Iterable<ShelterModel> findByZip(String zip);
    
}
