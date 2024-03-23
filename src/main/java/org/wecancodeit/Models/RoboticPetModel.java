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
    private String model;

    @Column(length = 50, nullable = false)
    private String manufacturer;

    @Min(0)
    @Max(100)
    @Column(nullable = false)
    private int energyLevel;

    @Min(0)
    @Max(100)
    @Column(nullable = false)
    private int oilLevel;

    @ManyToOne
    private ShelterModel shelterModel;

    private RoboticHealthEnum roboticPetHealth;

    public RoboticPetModel() {
        super();
    }

    public RoboticPetModel(String name, PetTypeEnum petType, String imageUrl, String petModel, String petManufacturer,
            @Min(0) @Max(100) int petEnergyLevel, @Min(0) @Max(100) int petOilLevel,
            RoboticHealthEnum roboticPetHealth,ArrayList<Long> scheduledTaskIds) {
        super(name, petType, imageUrl, scheduledTaskIds);
        this.model = petModel;
        this.manufacturer = petManufacturer;
        this.energyLevel = petEnergyLevel;
        this.oilLevel = petOilLevel;
        this.roboticPetHealth = roboticPetHealth;
        
    }

    @Override
    public String toString() {
        return super.toString() + "RoboticPetModel [petModel=" + model + ", petManufacturer=" + manufacturer
                + ", petEnergyLevel="
                + energyLevel + ", petOilLevel=" + oilLevel + ", roboticPetHealth=" + roboticPetHealth + "]";
    }

}
