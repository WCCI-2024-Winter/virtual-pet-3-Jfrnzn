package org.wecancodeit.Services;

import java.util.*;

import org.springframework.stereotype.Service;
import org.wecancodeit.Models.*;

import org.wecancodeit.Repositories.VolunteerRepository;

import jakarta.annotation.Resource;

@Service
public class VolunteerService {
    @Resource
    private VolunteerRepository volunteerRepository;

    public VolunteerService() {
    }

    public VolunteerService(VolunteerRepository volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
    }

    /**
     * 
     * @return
     */
    public Iterable<VolunteerModel> findAll() {
        Iterable<VolunteerModel> volunteers = new ArrayList<>();
        try {
            volunteers = volunteerRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
        return volunteers;
    }

    /**
     * 
     * @param id
     * @return
     */
    public VolunteerModel findById(Long id) {
        VolunteerModel volunteer = null;
        try {
            Optional<VolunteerModel> optVolunteer = volunteerRepository.findById(id);

            if (optVolunteer.isPresent()) {
                volunteer = optVolunteer.get();
            }
        } catch (Exception ex) {
            throw ex;
        }
        return volunteer;
    }

    /**
     * 
     * @param name
     * @param zip
     * @return
     */
    public Iterable<VolunteerModel> findByName(String name/** , String zip*/) {
        Iterable<VolunteerModel> volunteer = new ArrayList<>();
        try {
            // if (zip != null && zip.length() > 2) {
            //     zip = zip.substring(0, 2);
            //     // volunteer = volunteerRepository.findByNameZip(name, zip);
            // } else {
                volunteer = volunteerRepository.findByName(name);
            }
        /**}*/ catch (Exception ex) {
            throw ex;
        }
        return volunteer;
    }

    /**
     * 
     * @param id
     * @return
     */
    public boolean deleteVolunteer(long id) {
        boolean result = false;
        try {
            volunteerRepository.deleteById(id);
            Optional<VolunteerModel> optVolunteer = volunteerRepository.findById(id);
            if (!optVolunteer.isPresent()) {
                result = true;
            }
        } catch (Exception ex) {
            throw ex;
        }

        return result;
    }

    /**
     * 
     * @param volunteer
     * @return
     */
    public VolunteerModel saveVolunteer(VolunteerModel volunteer) {
        try {
            if (BaseService.isValidContact(volunteer)) {
                volunteer = volunteerRepository.save(volunteer);
            }
        } catch (Exception ex) {
            throw ex;
        }

        return volunteer;
    }
}
