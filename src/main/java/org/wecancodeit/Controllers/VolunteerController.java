package org.wecancodeit.Controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.Models.VolunteerModel;
import org.wecancodeit.Services.VolunteerService;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/api/v1/Volunteers/")
public class VolunteerController {

    @Resource
    private final VolunteerService volunteerService;

    public VolunteerController(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;
    }

    @GetMapping
    public Iterable<VolunteerModel> getAllVolunteers() {
        return volunteerService.findAll();
    }

    @GetMapping("{id}")
    public VolunteerModel getVolunteer(@PathVariable Long id) {
        return volunteerService.findById(id);
    }

    // @GetMapping("{name}/{zip}")
    // public Iterable<VolunteerModel> getByNameZip(@PathVariable String name, String zip) {
    //     return volunteerService.findByName(name, zip);
    // }

    @DeleteMapping("{id}")
    public boolean deleteVolunteer(@PathVariable Long id) {
        return volunteerService.deleteVolunteer(id);
    }

    @PostMapping
    public VolunteerModel addVolunteerModel(@RequestBody VolunteerModel volunteerModel) {
        return volunteerService.saveVolunteer(volunteerModel);
    }

    @PutMapping
    public VolunteerModel saveVolunteerModel(@RequestBody VolunteerModel volunteerModel) {
        return volunteerService.saveVolunteer(volunteerModel);
    }
}
