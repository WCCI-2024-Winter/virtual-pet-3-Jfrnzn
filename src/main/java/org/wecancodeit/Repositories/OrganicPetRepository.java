package org.wecancodeit.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.Models.OrganicPetModel;

public interface OrganicPetRepository extends CrudRepository<OrganicPetModel, Long>{

/**
 * 
 * @param breed
 * @return
 */
    Iterable<OrganicPetModel> findByBreed(String breed);

}
