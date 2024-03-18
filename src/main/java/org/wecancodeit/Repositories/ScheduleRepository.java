package org.wecancodeit.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.Models.ScheduleModel;

public interface ScheduleRepository extends CrudRepository<ScheduleModel, Long> {
    
}
