package org.wecancodeit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.Models.AdoptersModel;
import org.wecancodeit.Models.OrganicPetModel;
import org.wecancodeit.Models.PetMaintenanceModel;
import org.wecancodeit.Models.PetTaskScheduleModel;
import org.wecancodeit.Models.RoboticPetModel;
import org.wecancodeit.Models.ShelterModel;
import org.wecancodeit.Models.VolunteerModel;
import org.wecancodeit.Models.Enums.AdoptionStatusEnum;
import org.wecancodeit.Models.Enums.PetHealthEnum;
import org.wecancodeit.Models.Enums.PetMoodEnum;
import org.wecancodeit.Models.Enums.PetTaskEnum;
import org.wecancodeit.Models.Enums.PetTempermentEnum;
import org.wecancodeit.Models.Enums.PetTypeEnum;
import org.wecancodeit.Models.Enums.RoboticHealthEnum;
import org.wecancodeit.Services.*;

import jakarta.annotation.Resource;

@Component
public class Populator implements CommandLineRunner {

        @Resource
        private final AdopterService adopterService;

        @Resource
        private final OrganicPetService organicPetService;

        @Resource
        private final PetMaintenanceService petMaintenanceService;

        @Resource
        private final PetTaskScheduleService petTaskScheduleService;

        @Resource
        private final RoboticPetService roboticPetService;

        @Resource
        private final ShelterService shelterService;

        @Resource
        private final VolunteerService volunteerService;

        public Populator(AdopterService adopterService, OrganicPetService organicPetService,
                        PetMaintenanceService petMaintenanceService, PetTaskScheduleService petTaskScheduleService,
                        RoboticPetService roboticPetService, ShelterService shelterService,
                        VolunteerService volunteerService) {
                this.adopterService = adopterService;
                this.organicPetService = organicPetService;
                this.petMaintenanceService = petMaintenanceService;
                this.petTaskScheduleService = petTaskScheduleService;
                this.roboticPetService = roboticPetService;
                this.shelterService = shelterService;
                this.volunteerService = volunteerService;
        }

        @Override
        public void run(String... args) throws Exception {


                /**Each table will have its own unique id, so each new model will start at 1l, then 2l then 3l etc.  */



                /** Shelter populator */
                // Shelter 1
                ShelterModel shelterModel = new ShelterModel("Human Shelter", "add 1", "add 2", "city", "12345",
                                "oh", "1234566789", "no1@gmail.com", "cute-dog-house_1308-115570.avif",
                                "https://www.google.com");
                shelterModel.setId(1l);/** this id reads as "1" and " a lowercase L" */
                shelterService.saveShelter(shelterModel);

                // Shelter 2
                ShelterModel shelterModel2 = new ShelterModel("Furry Friends Shelter", "456 Oak Avenue", "Apt 200",
                                "Townsville", "54321",
                                "texas", "9876543210", "info@furryfriends.com", "furry-friends_5678-1234.avif",
                                "https://www.furryfriends.org");
                shelterModel.setId(2L);
                shelterService.saveShelter(shelterModel);

                // Shelter 3
                ShelterModel shelterModel3 = new ShelterModel("Pawsome Refuge", "789 Elm Street", "Unit 300",
                                "Villageville",
                                "67890", "ohio", "4567890123", "info@pawsome.org", "pawsome-refuge_9012-3456.avif",
                                "https://www.pawsome.org");
                shelterModel.setId(3L);
                shelterService.saveShelter(shelterModel);

                // Shelter 4
                ShelterModel shelterModel4 = new ShelterModel("Pet Haven", "123 Main Street", "Suite 100", "Cityville",
                                "90210", "california", "1234567890", "info@pethaven.com", "pet-haven_1234-5678.avif",
                                "https://www.pethaven.com");
                shelterModel.setId(4l);
                shelterService.saveShelter(shelterModel);

                AdoptersModel adoptersModel = new AdoptersModel("Adopter 1", "123 adopter st", "adopter 3nd address",
                                "adopter city", "12345","ohio","9377371111", "adopterEmail.com", "adopter.jpg", PetTypeEnum.DOG, AdoptionStatusEnum.PENDING);
                adoptersModel.setId(1l);
                adopterService.saveAdopter(adoptersModel);
              

                VolunteerModel volunteerModel = new VolunteerModel("Volly", "123 Address", "Add 2", "VolunteerCity",
                                "22222",
                                "volunteerState", "1234566789", "VolunteerEmail@gmail.com", "volunteer.jpg");
                volunteerModel.setId(1l);
                volunteerService.saveVolunteer(volunteerModel);
                /**
                 * Organic Pet populator
                 */

                OrganicPetModel organicPetModel = new OrganicPetModel("Dog1", PetTypeEnum.DOG, "border collie.jpg",
                                "Border Collie", 2, PetHealthEnum.HEALTHY, PetMoodEnum.EXCITED,
                                PetTempermentEnum.ACTIVE, true,
                                null);
                organicPetModel.setId(1l);
                organicPetService.saveOrganicPet(organicPetModel);
                // /**
                // * Robotic Pet Populator
                // */

                RoboticPetModel roboticPetModel = new RoboticPetModel("RoboDog", PetTypeEnum.ROBOTIC_DOG,
                                "istockphoto-1143731884-612x612.jpg", "thisPetModel", "theBestManufacturer",
                                50, 10, RoboticHealthEnum.NORMAL, null);
                roboticPetModel.setId(1l);
                roboticPetService.saveRoboticPet(roboticPetModel);

                PetMaintenanceModel petMaintenanceModel = new PetMaintenanceModel("Feed", 10, PetTypeEnum.DOG,
                                PetTaskEnum.FEED_PET);
                petMaintenanceModel.setId(1l);
                petMaintenanceService.savePetMaintenance(petMaintenanceModel);

                /**
                 * PetTaskSchedule Populator
                 */
                PetTaskScheduleModel petTaskScheduleModel = new PetTaskScheduleModel(1l, 1l, 1l, null);
                petTaskScheduleModel.setId(1l);
                petTaskScheduleService.savePetSchedule(petTaskScheduleModel);

        }

}