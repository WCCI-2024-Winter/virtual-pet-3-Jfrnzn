package org.wecancodeit.Repositories;

import org.springframework.data.repository.CrudRepository;

import org.wecancodeit.Models.VolunteerModel;

public interface VolunteerRepository extends CrudRepository<VolunteerModel, Long> {

    /**
     * 
     * @param name
     * @return
     */
    Iterable<VolunteerModel> findByName(String name);

    /**
     * 
     * @param name
     * @param zip
     * @return
     */
    // Iterable<VolunteerModel> findByNameZip(String name, String zip);
}
