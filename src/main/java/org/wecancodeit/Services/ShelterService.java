package org.wecancodeit.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.wecancodeit.Models.ShelterModel;
import org.wecancodeit.Repositories.ShelterRepository;

import jakarta.annotation.Resource;

@Service
public class ShelterService {
    @Resource
    private ShelterRepository shelterRepository;

    public ShelterService() {
    }

    /**
     * 
     * @param shelterRepository
     */
    public ShelterService(ShelterRepository shelterRepository) {
        this.shelterRepository = shelterRepository;
    }

    /**
     * 
     * @return
     */
    public Iterable<ShelterModel> findAll() {
        Iterable<ShelterModel> shelters = new ArrayList<>();
        try {
            shelters = shelterRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
        return shelters;
    }

    /**
     * 
     * @param id
     * @return
     */
    public ShelterModel findById(Long id) {
        ShelterModel shelters = null;
        try {
            Optional<ShelterModel> optShelters = shelterRepository.findById(id);
            if (optShelters.isPresent()) {
                shelters = optShelters.get();
            }
        } catch (Exception ex) {
            throw ex;
        }
        return shelters;
    }

    /**
     * 
     * @param id
     * @return
     */
    public boolean deleteShelter(long id) {
        boolean result = false;
        try {
            shelterRepository.deleteById(id);
            Optional<ShelterModel> optShelter = shelterRepository.findById(id);
            if (!optShelter.isPresent()) {
                result = true;
            }
        } catch (Exception ex) {
            throw ex;
        }
        return result;
    }

    /**
     * 
     * @param shelter
     * @return
     */
    public ShelterModel saveShelter(ShelterModel shelter) {
        try {
            if (BaseService.isValidContact(shelter)) {
                shelter = shelterRepository.save(shelter);
            }
        } catch (Exception ex) {
            throw ex;
        }

        return shelter;
    }

    /**
     * 
     * @param name
     * @param zip
     * @return
     */
    public Iterable<ShelterModel> findByName(String name) {
        Iterable<ShelterModel> shelter = new ArrayList<>();
        try {
            shelter = shelterRepository.findByName(name);
        } catch (Exception ex) {
            throw ex;
        }
        return shelter;
    }

    /**
     * 
     * @param zip
     * @return
     */
    public Iterable<ShelterModel> findByZip(String zip) {
        Iterable<ShelterModel> shelter = new ArrayList<>();
        try {
            if (zip != null && zip.length() > 2) {
                zip = zip.substring(0, 2);
                shelter = shelterRepository.findByZip(zip);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return shelter;
    }
}