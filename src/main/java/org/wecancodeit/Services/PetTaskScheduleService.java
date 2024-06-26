package org.wecancodeit.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.wecancodeit.Models.PetTaskScheduleModel;
import org.wecancodeit.Repositories.PetScheduleRepository;
import jakarta.annotation.Resource;

@Service
public class PetTaskScheduleService {
    @Resource
    private PetScheduleRepository petScheduleRepository;

    /**
     * 
     */
    public PetTaskScheduleService() {
    }

    /**
     * 
     * @param petScheduleRepository
     */

    public PetTaskScheduleService(PetScheduleRepository petScheduleRepository) {
        this.petScheduleRepository = petScheduleRepository;
    }

    /**
     * 
     * @return
     */
    public Iterable<PetTaskScheduleModel> findAll() {
        Iterable<PetTaskScheduleModel> schedule = new ArrayList<>();
        try {
            schedule = petScheduleRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
        return schedule;
    }

    /**
     * 
     * @param id
     * @return
     */
    public Iterable<PetTaskScheduleModel> findByVolunteerId(Long volunteerId) {
        Iterable<PetTaskScheduleModel> schedule = null;
        try {
            schedule = petScheduleRepository.findByVolunteerId(volunteerId);
        } catch (Exception ex) {
            throw ex;
        }
        return schedule;
    }

    /**
     * 
     * @param id
     * @return
     */
    public Iterable<PetTaskScheduleModel> findByPetId(Long petId) {
        Iterable<PetTaskScheduleModel> schedule = null;
        try {
            schedule = petScheduleRepository.findByPetId(petId);
        } catch (Exception ex) {
            throw ex;
        }
        return schedule;
    }

    /**
     * 
     * @param taskId
     * @return
     */
    public Iterable<PetTaskScheduleModel> findByTaskId(Long taskId) {
        Iterable<PetTaskScheduleModel> schedule = null;
        try {
            schedule = petScheduleRepository.findByTaskId(taskId);
        } catch (Exception ex) {
            throw ex;
        }
        return schedule;
    }

    public boolean deleteSchedule(long id) {
        boolean result = false;
        try {
            petScheduleRepository.deleteById(id);
            Optional<PetTaskScheduleModel> optSchedule = petScheduleRepository.findById(id);
            if (!optSchedule.isPresent()) {
                result = true;
            }
        } catch (Exception ex) {
            throw ex;
        }
        return result;
    }

    public PetTaskScheduleModel savePetSchedule(PetTaskScheduleModel schedule) {
        try {
            if (BaseService.isValidPetTaskSchedule(schedule)) {
                schedule = petScheduleRepository.save(schedule);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return schedule;
    }
}
