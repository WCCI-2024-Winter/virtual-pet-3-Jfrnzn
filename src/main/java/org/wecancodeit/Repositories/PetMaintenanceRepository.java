package org.wecancodeit.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.Models.PetMaintenanceModel;

public interface PetMaintenanceRepository extends CrudRepository<PetMaintenanceModel, Long>{
    
        Iterable<PetMaintenanceModel> findByName(String name);

}
