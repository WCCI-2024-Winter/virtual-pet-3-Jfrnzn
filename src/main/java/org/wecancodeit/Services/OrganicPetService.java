package org.wecancodeit.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.wecancodeit.Models.OrganicPetModel;
import org.wecancodeit.Repositories.OrganicPetRepository;

import jakarta.annotation.Resource;

@Service
public class OrganicPetService {
    @Resource
    private OrganicPetRepository organicPetRepository;

    public OrganicPetService() {
    }

    public OrganicPetService(OrganicPetRepository organicPetRepository) {
        this.organicPetRepository = organicPetRepository;

    }

    public Iterable<OrganicPetModel> findAll() {
        Iterable<OrganicPetModel> Opet = new ArrayList<>();
        try {
            Opet = organicPetRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
        return Opet;
    }

    public OrganicPetModel findById(Long id) {
        OrganicPetModel organicPet = null;
        try {
            Optional<OrganicPetModel> optPet = organicPetRepository.findById(id);
            if (optPet.isPresent()) {
                organicPet = optPet.get();
            }
        } catch (Exception ex) {
            throw ex;
        }
        return organicPet;
    }

    public boolean deleteOrganicPet(long id) {
        boolean result = false;
        try {
            organicPetRepository.deleteById(id);
            Optional<OrganicPetModel> optPet = organicPetRepository.findById(id);
            if (!optPet.isPresent()) {
                result = true;
            }
        } catch (Exception ex) {
            throw ex;
        }
        return result;
    }

    public OrganicPetModel saveOrganicPet(OrganicPetModel pet) {
        try {
            if (BaseService.isValidOrganicPet(pet)) {
                pet = organicPetRepository.save(pet);
            }
        } catch (Exception ex) {
            throw ex;
        }

        return pet;
    }

    public Iterable<OrganicPetModel> findByBreed(String breed) {
        Iterable<OrganicPetModel> pets = new ArrayList<>();
        try {
            pets = organicPetRepository.findByBreed(breed);
        } catch (Exception ex) {
            throw ex;
        }
        return pets;
    }
}
