package org.wecancodeit.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.Models.AdoptersModel;


public interface AdoptersRepository extends CrudRepository<AdoptersModel, Long> {
    /**
     * 
     * @param name
     * @return
     */
    Iterable<AdoptersModel> findByName(String name);

    /**
     * 
     * @param name
     * @param zip
     * @return
     *         //
     */
    // Iterable<AdoptersModel> findByNameZip(String name, String zip);

    /**
     * 
     * @param preferredPetType
     * @return
     */

    /** changed pet type from string to the enum */
    Iterable<AdoptersModel> findByPreferredPetType(String preferredPetType);

    /**
     * 
     * @param preferredPetType
     * @param zip
     * @return
     */

    // Iterable<AdoptersModel> findPreferredPetType(String preferredPetType, String
    // zip);

}
