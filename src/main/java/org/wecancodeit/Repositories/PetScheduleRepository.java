package org.wecancodeit.Repositories;



import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.Models.PetTaskScheduleModel;

public interface PetScheduleRepository extends CrudRepository<PetTaskScheduleModel, Long> {
   
    Iterable<PetTaskScheduleModel> findByVolunteerId(Long volunteerId);

    Iterable<PetTaskScheduleModel> findByPetId(Long petId);

    Iterable<PetTaskScheduleModel> findByTaskId(Long taskId);
}