package org.wecancodeit.Services;

import java.util.*;

import org.springframework.stereotype.Service;
import org.wecancodeit.Models.AdoptersModel;
import org.wecancodeit.Repositories.AdoptersRepository;

import jakarta.annotation.Resource;

@Service
public class AdopterService {
    @Resource
    private AdoptersRepository adopterRepository;

    public AdopterService() {
    }

    public AdopterService(AdoptersRepository adopterRepository) {
        this.adopterRepository = adopterRepository;
    }

    public Iterable<AdoptersModel> findAll() {
        Iterable<AdoptersModel> adopters = new ArrayList<>();
        try {
            adopters = adopterRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
        return adopters;
    }

    public AdoptersModel findById(Long id) {
        AdoptersModel adopter = null;
        try {
            Optional<AdoptersModel> optAdopter = adopterRepository.findById(id);

            if (optAdopter.isPresent()) {
                adopter = optAdopter.get();
            }
        } catch (Exception ex) {
            throw ex;
        }
        return adopter;
    }

    public Iterable<AdoptersModel> findByName(String name, String zip) {
        Iterable<AdoptersModel> adopters = new ArrayList<>();
        try {
            if (zip != null && zip.length() > 2) {
                zip = zip.substring(0, 2);
                adopters = adopterRepository.findByNameZip(name, zip);
            } else {
                adopters = adopterRepository.findByName(name);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return adopters;
    }

    public boolean deleteAdopter(long id) {
        boolean result = false;
        try {
            adopterRepository.deleteById(id);
            Optional<AdoptersModel> optAdopter = adopterRepository.findById(id);
            if (!optAdopter.isPresent()) {
                result = true;
            }
        } catch (Exception ex) {
            throw ex;
        }

        return result;
    }

    public AdoptersModel saveAdopter(AdoptersModel adopter) {
        try {
            if (BaseService.isValidContact(adopter)) {
                adopter = adopterRepository.save(adopter);
            }
        } catch (Exception ex) {
            throw ex;
        }

        return adopter;
    }

    
    public Iterable<AdoptersModel> findByPreferredPetType(String preferredPetType, String zip) {
        Iterable<AdoptersModel> adopters = new ArrayList<>();
        try {
            if (zip != null && zip.length() > 2) {
                zip = zip.substring(0, 2);
                adopters = adopterRepository.findPreferredPetType(preferredPetType, zip);
            } else {
                adopters = adopterRepository.findPreferredPetType(preferredPetType);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return adopters;
    }

}
