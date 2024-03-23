package org.wecancodeit.Services;

import org.wecancodeit.Models.*;

public class BaseService {
    public static boolean isValidContact(ContactModel contact) {
        return true;
    }

    public static boolean isValidOrganicPet(OrganicPetModel organicPet) {
        return true;
    }

    public static boolean isValidRoboticPet(RoboticPetModel organicPet) {
        return true;
    }

    public static boolean isValidMaintenance(PetMaintenanceModel maintenance) {
        return true;
    }

    public static boolean isValidPetTaskSchedule(PetTaskScheduleModel schedule) {
        return true;
    }
}
