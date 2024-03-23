package org.wecancodeit.Controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.Models.OrganicPetModel;
import org.wecancodeit.Services.OrganicPetService;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/api/v1/OrganicPet/")
public class OrganicPetController {

    @Resource
    private final OrganicPetService organicPetService;

    public OrganicPetController(OrganicPetService organicPetService) {
        this.organicPetService = organicPetService;
    }

    @GetMapping
    public Iterable<OrganicPetModel> getAllOrganicPets() {
        return organicPetService.findAll();
    }

    @GetMapping("{breed}")
    public Iterable<OrganicPetModel> getOrganicPetByBreed(@PathVariable String breed) {
        return organicPetService.findByBreed(breed);
    }

    @GetMapping("{id}")
    public OrganicPetModel getOrganicPet(@PathVariable Long id) {
        return organicPetService.findById(id);
    }

    @DeleteMapping("{id}")
    public boolean deleteOrganicPet(@PathVariable Long id) {
        return organicPetService.deleteOrganicPet(id);
    }

    @PostMapping
    public OrganicPetModel addOrganicPet(@RequestBody OrganicPetModel organicPetModel) {
        return organicPetService.saveOrganicPet(organicPetModel);
    }

    @PutMapping
    public OrganicPetModel saveOrganicPet(@RequestBody OrganicPetModel organicPetModel) {
        return organicPetService.saveOrganicPet(organicPetModel);
    }
}
