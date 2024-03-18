package org.wecancodeit.Repositories;

import org.springframework.data.repository.CrudRepository;

import org.wecancodeit.Models.PetMaintenanceModel;

public interface MaintenanceRepository extends CrudRepository<PetMaintenanceModel, Long>{
    
}
