package org.wecancodeit.Services;

import java.util.*;

import org.springframework.stereotype.Service;
import org.wecancodeit.Models.PetMaintenanceModel;
import org.wecancodeit.Repositories.PetMaintenanceRepository;

import jakarta.annotation.Resource;

@Service
public class PetMaintenanceService {
    @Resource
    private PetMaintenanceRepository petMaintenanceRepository;

    public PetMaintenanceService() {
    }

    public PetMaintenanceService(PetMaintenanceRepository petMaintenanceRepository) {
        this.petMaintenanceRepository = petMaintenanceRepository;
    }

    /**
     * 
     * @return
     */
    public Iterable<PetMaintenanceModel> findAll() {
        Iterable<PetMaintenanceModel> petMaintenance = new ArrayList<>();
        try {
            petMaintenance = petMaintenanceRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
        return petMaintenance;
    }

    /**
     * 
     * @param id
     * @return
     */
    public PetMaintenanceModel findById(Long id) {
        PetMaintenanceModel petMaintenance = null;
        try {
            Optional<PetMaintenanceModel> maintenance = petMaintenanceRepository.findById(id);
            if (maintenance.isPresent()) {
                petMaintenance = maintenance.get();
            }
        } catch (Exception ex) {
            throw ex;
        }
        return petMaintenance;
    }

    /**
     * 
     * @param id
     * @return
     */
    public boolean deletePetMaintenance(long id) {
        boolean result = false;
        try {
            petMaintenanceRepository.deleteById(id);
            Optional<PetMaintenanceModel> maintenance = petMaintenanceRepository.findById(id);
            if (!maintenance.isPresent()) {
                result = true;
            }
        } catch (Exception ex) {
            throw ex;
        }
        return result;
    }

    /**
     * 
     * @param maintenance
     * @return
     */
    public PetMaintenanceModel savePetMaintenance(PetMaintenanceModel maintenance) {
        try {
            if (BaseService.isValidMaintenance(maintenance)) {
                maintenance = petMaintenanceRepository.save(maintenance);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return maintenance;
    }
    /**
     * 
     * @param name
     * @return
     */
    public Iterable<PetMaintenanceModel> findByName(String name) {
        Iterable<PetMaintenanceModel> maintenance = new ArrayList<>();
        try {
            maintenance = petMaintenanceRepository.findByName(name);
        } catch (Exception ex) {
            throw ex;
        }
        return maintenance;
    }

}
