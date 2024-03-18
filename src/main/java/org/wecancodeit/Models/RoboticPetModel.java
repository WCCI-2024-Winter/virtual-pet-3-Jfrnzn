package org.wecancodeit.Models;

import java.util.ArrayList;

import org.wecancodeit.Models.Enums.PetTypeEnum;
import org.wecancodeit.Models.Enums.RoboticHealthEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "t_roboticPet")
public class RoboticPetModel extends PetModel {

    @Column(length = 50, nullable = false)
    private String petModel;

    @Column(length = 50, nullable = false)
    private String petManufacturer;

    @Min(0)
    @Max(100)
    @Column(nullable = false)
    private int petEnergyLevel;

    @Min(0)
    @Max(100)
    @Column(nullable = false)
    private int petOilLevel;

    @ManyToOne
    private ShelterModel shelterModel;

    private RoboticHealthEnum roboticPetHealth;

    public RoboticPetModel() {
        super();
    }

    public RoboticPetModel(String name, PetTypeEnum petType, String imageUrl, String petModel, String petManufacturer,
            @Min(0) @Max(100) int petEnergyLevel, @Min(0) @Max(100) int petOilLevel,
            RoboticHealthEnum roboticPetHealth,ArrayList<Long> scheduledTaskIds,
            ArrayList<Long> maintenanceTaskIds) {
        super(name, petType, imageUrl, scheduledTaskIds,
        maintenanceTaskIds);
        this.petModel = petModel;
        this.petManufacturer = petManufacturer;
        this.petEnergyLevel = petEnergyLevel;
        this.petOilLevel = petOilLevel;
        this.roboticPetHealth = roboticPetHealth;
    }

    @Override
    public String toString() {
        return super.toString() + "RoboticPetModel [petModel=" + petModel + ", petManufacturer=" + petManufacturer
                + ", petEnergyLevel="
                + petEnergyLevel + ", petOilLevel=" + petOilLevel + ", roboticPetHealth=" + roboticPetHealth + "]";
    }

}
