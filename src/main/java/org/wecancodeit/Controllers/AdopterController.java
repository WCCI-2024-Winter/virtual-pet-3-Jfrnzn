package org.wecancodeit.Controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.Models.AdoptersModel;
import org.wecancodeit.Services.AdopterService;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/api/v1/adopters/")
public class AdopterController {

    @Resource
    private final AdopterService adopterService;

    public AdopterController(AdopterService adopterService) {
        this.adopterService = adopterService;
    }

    @GetMapping
    public Iterable<AdoptersModel> getAllAdopters() {
        return adopterService.findAll();
    }

    @GetMapping("{id}")
    public AdoptersModel getAdopter(@PathVariable Long id) {
        return adopterService.findById(id);
    }

    // @GetMapping("{name}/{zip}")
    // public Iterable<AdoptersModel> getByNameZip(@PathVariable String name, String zip) {
    //     return adopterService.findByName(name, zip);
    // }

    @GetMapping("preferredPetType/{preferredPetType}")
    public Iterable<AdoptersModel> findByPreferredPetType(@PathVariable String preferredPetType
           /**, @PathVariable String zip*/) {
        return adopterService.findByPreferredPetType(preferredPetType/**, zip*/);
    }

    @DeleteMapping("{id}")
    public boolean deleteAdopter(@PathVariable Long id) {
        return adopterService.deleteAdopter(id);
    }

    @PostMapping
    public AdoptersModel addAdopterModel(@RequestBody AdoptersModel adopterModel) {
        return adopterService.saveAdopter(adopterModel);
    }

    @PutMapping
    public AdoptersModel saveAdopterModel(@RequestBody AdoptersModel adopterModel) {
        return adopterService.saveAdopter(adopterModel);
    }

}
