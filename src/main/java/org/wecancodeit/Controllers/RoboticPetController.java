package org.wecancodeit.Controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.Models.RoboticPetModel;
import org.wecancodeit.Services.RoboticPetService;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/api/v1/RoboticPets/")
public class RoboticPetController {

    @Resource
    private final RoboticPetService roboticPetService;

    public RoboticPetController(RoboticPetService roboticPetService) {
        this.roboticPetService = roboticPetService;
    }

    @GetMapping
    public Iterable<RoboticPetModel> getAllRoboticPets() {
        return roboticPetService.findAll();
    }

    @GetMapping("{breed}")
    public Iterable<RoboticPetModel> getRoboticPetByManufacturer(@PathVariable String manufacturer) {
        return roboticPetService.findByManufacturer(manufacturer);
    }

    @GetMapping("{id}")
    public RoboticPetModel getRoboticPet(@PathVariable Long id) {
        return roboticPetService.findById(id);
    }

    @DeleteMapping("{id}")
    public boolean deleteRoboticPet(@PathVariable Long id) {
        return roboticPetService.deleteRoboticPet(id);
    }

    @PostMapping
    public RoboticPetModel addRoboticPet(@RequestBody RoboticPetModel roboticPetModel) {
        return roboticPetService.saveRoboticPet(roboticPetModel);
    }

    @PutMapping
    public RoboticPetModel saveRoboticPet(@RequestBody RoboticPetModel roboticPetModel) {
        return roboticPetService.saveRoboticPet(roboticPetModel);
    }
}
