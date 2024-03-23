package org.wecancodeit.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.Models.ShelterModel;
import org.wecancodeit.Services.ShelterService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/Shelter/")
public class ShelterController {

    @Resource
    private final ShelterService shelterService;

    public ShelterController(ShelterService shelterService) {
        this.shelterService = shelterService;
    }

    @GetMapping
    public Iterable<ShelterModel> getAllShelters() {
        return shelterService.findAll();
    }

    @GetMapping("{id}")
    public ShelterModel getShelter(@PathVariable Long id) {
        return shelterService.findById(id);
    }

    @GetMapping("{name}")
    public Iterable<ShelterModel> getByName(@PathVariable String name) {
        return shelterService.findByName(name);
    }

    @GetMapping("{zip}")
    public Iterable<ShelterModel> getByZip(@PathVariable String zip) {
        return shelterService.findByZip(zip);
    }

    @DeleteMapping("{id}")
    public boolean deleteShelter(@PathVariable Long id) {
        return shelterService.deleteShelter(id);
    }

    @PostMapping
    public ShelterModel addShelterModel(@RequestBody ShelterModel shelterModel) {
        return shelterService.saveShelter(shelterModel);
    }

    @PutMapping
    public ShelterModel saveShelterModel(@RequestBody ShelterModel shelterModel) {
        return shelterService.saveShelter(shelterModel);
    }

}
