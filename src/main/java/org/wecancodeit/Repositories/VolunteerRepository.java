package org.wecancodeit.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.Models.VolunteerModel;

public interface VolunteerRepository extends CrudRepository<VolunteerModel, Long> {
    
}
