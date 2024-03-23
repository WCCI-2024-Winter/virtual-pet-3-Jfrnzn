package org.wecancodeit.Controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.Models.PetTaskScheduleModel;
import org.wecancodeit.Services.PetTaskScheduleService;

import jakarta.annotation.Resource;

@RestController
@RequestMapping
public class PetTaskScheduleController {

    @Resource
    private final PetTaskScheduleService petTaskScheduleService;

    public PetTaskScheduleController(PetTaskScheduleService petTaskScheduleService) {
        this.petTaskScheduleService = petTaskScheduleService;
    }

    @GetMapping
    public Iterable<PetTaskScheduleModel> getAllPetTaskSchedule() {
        return petTaskScheduleService.findAll();
    }

    @GetMapping("{taskId}")
    public Iterable<PetTaskScheduleModel> getPetTaskScheduleTaskId(@PathVariable Long taskId) {
        return petTaskScheduleService.findByTaskId(taskId);
    }

    @GetMapping("{volunteerId}")
    public Iterable<PetTaskScheduleModel> getPetTaskScheduleByVolunteerId(@PathVariable Long volunteerId) {
        return petTaskScheduleService.findByVolunteerId(volunteerId);
    }

    @GetMapping("{petId}")
    public Iterable<PetTaskScheduleModel> getPetTaskSchedulePetId(@PathVariable Long petId) {
        return petTaskScheduleService.findByPetId(petId);
    }

    @DeleteMapping("{id}")
    public boolean deletePetTaskSchedule(@PathVariable Long id) {
        return petTaskScheduleService.deleteSchedule(id);
    }

    @PostMapping("{id}")
    public PetTaskScheduleModel addPetTaskSchedule(@PathVariable PetTaskScheduleModel schedule) {
        return petTaskScheduleService.savePetSchedule(schedule);
    }

    @PutMapping("{id}")
    public PetTaskScheduleModel savePetTaskSchedule(@PathVariable PetTaskScheduleModel schedule) {
        return petTaskScheduleService.savePetSchedule(schedule);
    }
}
