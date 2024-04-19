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

                /**
                 * Each table will have its own unique id, so each new model will start at 1l,
                 * then 2l then 3l etc.
                 */

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
                                "TX", "9876543210", "info@furryfriends.com", "furry-friends_5678-1234.avif",
                                "https://www.furryfriends.org");
                shelterModel.setId(2l);
                shelterService.saveShelter(shelterModel2);

                // Shelter 3
                ShelterModel shelterModel3 = new ShelterModel("Pawsome Refuge", "789 Elm Street", "Unit 300",
                                "Villageville",
                                "67890", "oh", "4567890123", "info@pawsome.org", "pawsome-refuge_9012-3456.avif",
                                "https://www.pawsome.org");
                shelterModel.setId(3l);
                shelterService.saveShelter(shelterModel3);

                // Shelter 4
                ShelterModel shelterModel4 = new ShelterModel("Pet Haven", "123 Main Street", "Suite 100", "Cityville",
                                "90210", "ca", "1234567890", "info@pethaven.com", "pet-haven_1234-5678.avif",
                                "https://www.pethaven.com");
                shelterModel.setId(4l);
                shelterService.saveShelter(shelterModel4);

                VolunteerModel volunteerModel = new VolunteerModel("Volly", "123 Address", "Add 2", "VolunteerCity",
                                "22222",
                                "VA", "1234566789", "VolunteerEmail@gmail.com", "volunteer.jpg");
                volunteerModel.setId(1l);
                volunteerService.saveVolunteer(volunteerModel);

                AdoptersModel adoptersModel2 = new AdoptersModel("Adopter 1", "222 adopter st", "adopter 1nd address",
                                "adopter city", "12345", "oh", "9377371111", "adopterEmail.com", "adopter.jpg",
                                PetTypeEnum.DOG, AdoptionStatusEnum.PENDING);
                adoptersModel2.setId(2l);
                adoptersModel2.setShelterModel(shelterModel2);
                adopterService.saveAdopter(adoptersModel2);

                AdoptersModel adoptersModel1 = new AdoptersModel("test 1", "222 adopter st", "adopter 1nd address",
                                "adopter city", "12345", "oh", "9377371111", "adopterEmail.com", "adopter.jpg",
                                PetTypeEnum.DOG, AdoptionStatusEnum.PENDING);
                adoptersModel1.setId(1l);
                adoptersModel1.setShelterModel(shelterModel2);
                adopterService.saveAdopter(adoptersModel1);

                AdoptersModel adoptersModel3 = new AdoptersModel("Adopter 3", "333 adopter st", "adopter 3nd address",
                                "adopter city", "33333", "oh", "3333333333", "adopter3Email.com", "adopter.jpg",
                                PetTypeEnum.CAT, AdoptionStatusEnum.DENIED);
                adoptersModel3.setId(3l);
                adoptersModel3.setShelterModel(shelterModel);
                adopterService.saveAdopter(adoptersModel3);

                AdoptersModel adoptersModel4 = new AdoptersModel("Adopter 4", "123 adopter st", "adopter 4nd address",
                                "adopter city", "44444", "oh", "4444444444", "adopter4Email.com", "adopter.jpg",
                                PetTypeEnum.ROBOTIC_CAT, AdoptionStatusEnum.APPROVED);
                adoptersModel4.setId(4l);
                adoptersModel4.setShelterModel(shelterModel3);
                adopterService.saveAdopter(adoptersModel4);

                /**
                 * Organic Pet populator
                 */

                OrganicPetModel organicPetModel = new OrganicPetModel("Dog1", PetTypeEnum.DOG,
                                "https://purrandmutt.com/cdn/shop/products/the-king-custom-vintage-pet-portrait-421602.jpg",
                                "Border Collie", 2, PetHealthEnum.HEALTHY, PetMoodEnum.EXCITED,
                                PetTempermentEnum.ACTIVE, true,
                                null);
                organicPetModel.setId(1l);
                organicPetModel.setShelterModel(shelterModel4);
                organicPetService.saveOrganicPet(organicPetModel);

                OrganicPetModel organicPetModel2 = new OrganicPetModel("Dog2", PetTypeEnum.DOG,
                                "https://purrandmutt.com/cdn/shop/products/the-king-custom-vintage-pet-portrait-421602.jpg",
                                "Border Collie", 2, PetHealthEnum.HEALTHY, PetMoodEnum.EXCITED,
                                PetTempermentEnum.ACTIVE, true,
                                null);
                organicPetModel.setId(1l);
                organicPetModel.setShelterModel(shelterModel3);
                organicPetService.saveOrganicPet(organicPetModel);

                OrganicPetModel organicPetModel3 = new OrganicPetModel("Dog2", PetTypeEnum.DOG,
                                "src\\main\\border collie.jpg",
                                "Border Collie", 2, PetHealthEnum.HEALTHY, PetMoodEnum.EXCITED,
                                PetTempermentEnum.ACTIVE, true,
                                null);
                organicPetModel.setId(1l);
                organicPetModel.setShelterModel(shelterModel2);
                organicPetService.saveOrganicPet(organicPetModel);

                // /**
                // * Robotic Pet Populator
                // */

                RoboticPetModel roboticPetModel = new RoboticPetModel("RoboDog", PetTypeEnum.ROBOTIC_DOG,
                                "https://as1.ftcdn.net/v2/jpg/03/31/02/74/1000_F_331027429_mLSNlEUafthRQp8XXXxokPmgDVkOob9R.jpg",
                                "thisPetModel", "theBestManufacturer",
                                50, 10, RoboticHealthEnum.NORMAL, null);
                roboticPetModel.setId(1l);
                roboticPetModel.setShelterModel(shelterModel4);
                roboticPetService.saveRoboticPet(roboticPetModel);

                RoboticPetModel roboticPetModel2 = new RoboticPetModel("RoboDog no 2", PetTypeEnum.ROBOTIC_DOG,
                                "https://t4.ftcdn.net/jpg/05/56/09/81/240_F_556098117_GdiFN9p9j89dpt3JhLJsegV76tt1NhfA.jpg",
                                "thisPetModel", "theBestManufacturer",
                                50, 10, RoboticHealthEnum.NORMAL, null);
                roboticPetModel2.setId(2l);
                roboticPetModel2.setShelterModel(shelterModel4);
                roboticPetService.saveRoboticPet(roboticPetModel2);

                PetMaintenanceModel petMaintenanceModel = new PetMaintenanceModel("Feed", 10, PetTypeEnum.DOG,
                                PetTaskEnum.FEED_PET);
                petMaintenanceModel.setId(1l);
                petMaintenanceService.savePetMaintenance(petMaintenanceModel);

                RoboticPetModel roboticPetModel3 = new RoboticPetModel("RoboDog", PetTypeEnum.ROBOTIC_DOG,
                                "src\\main\\istockphoto-1143731884-612x612.jpg",
                                "thisPetModel", "theBestManufacturer",
                                50, 10, RoboticHealthEnum.NORMAL, null);
                roboticPetModel.setId(1l);
                roboticPetModel.setShelterModel(shelterModel3);
                roboticPetService.saveRoboticPet(roboticPetModel);

                /**
                 * PetTaskSchedule Populator
                 */
                PetTaskScheduleModel petTaskScheduleModel = new PetTaskScheduleModel(1l, 1l, 1l, null);
                petTaskScheduleModel.setId(1l);
                petTaskScheduleService.savePetSchedule(petTaskScheduleModel);

        }

}