package org.wecancodeit.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.wecancodeit.Models.RoboticPetModel;
import org.wecancodeit.Repositories.RoboticPetRepository;

import jakarta.annotation.Resource;

@Service
public class RoboticPetService {
    @Resource
    private RoboticPetRepository roboticPetRepository;

    public RoboticPetService() {
    }

    public RoboticPetService(RoboticPetRepository roboticPetRepository) {
        this.roboticPetRepository = roboticPetRepository;
    }

    public Iterable<RoboticPetModel> findAll() {
        Iterable<RoboticPetModel> Opet = new ArrayList<>();
        try {
            Opet = roboticPetRepository.findAll();

        } catch (Exception ex) {
            throw ex;
        }
        return Opet;
    }

    public RoboticPetModel findById(Long id) {
        RoboticPetModel roboticPet = null;
        try {
            Optional<RoboticPetModel> optPet = roboticPetRepository.findById(id);
            if (optPet.isPresent()) {
                roboticPet = optPet.get();
            }
        } catch (Exception ex) {
            throw ex;
        }
        return roboticPet;
    }

    public boolean deleteRoboticPet(long id) {
        boolean result = false;
        try {
            roboticPetRepository.deleteById(id);
            Optional<RoboticPetModel> optPet = roboticPetRepository.findById(id);
            if (!optPet.isPresent()) {
                result = true;
            }
        } catch (Exception ex) {
            throw ex;
        }
        return result;
    }

    public RoboticPetModel saveRoboticPet(RoboticPetModel pet) {
        try {
            if (BaseService.isValidRoboticPet(pet)) {
                pet = roboticPetRepository.save(pet);
            }
        } catch (Exception ex) {
            throw ex;
        }

        return pet;
    }

    public Iterable<RoboticPetModel> findByManufacturer(String petManufacturer) {
        Iterable<RoboticPetModel> pets = new ArrayList<>();
        try {
            pets = roboticPetRepository.findByManufacturer(petManufacturer);
        } catch (Exception ex) {
            throw ex;
        }
        return pets;
    }

}
