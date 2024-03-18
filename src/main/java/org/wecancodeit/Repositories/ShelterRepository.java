package org.wecancodeit.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.Models.ShelterModel;

public interface ShelterRepository extends CrudRepository<ShelterModel, Long> {
    
}
