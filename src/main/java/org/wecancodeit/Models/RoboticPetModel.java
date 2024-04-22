package org.wecancodeit.Models;

import java.util.ArrayList;

import org.wecancodeit.Models.Enums.PetTypeEnum;
import org.wecancodeit.Models.Enums.RoboticHealthEnum;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    public RoboticPetModel(String name, PetTypeEnum petType, String imageUrl, String model, String manufacturer,
            @Min(0) @Max(100) int energyLevel, @Min(0) @Max(100) int oilLevel,
            RoboticHealthEnum roboticPetHealth,ArrayList<Long> scheduledTaskIds) {
        super(name, petType, imageUrl, scheduledTaskIds);
        this.model = model;
        this.manufacturer = manufacturer;
        this.energyLevel = energyLevel;
        this.oilLevel = oilLevel;
        this.roboticPetHealth = roboticPetHealth;
        
    }
    


    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public int getOilLevel() {
        return oilLevel;
    }

    public ShelterModel getShelterModel() {
        return shelterModel;
    }

    @JsonIgnore
    public void setShelterModel(ShelterModel shelterModel) {
        this.shelterModel = shelterModel;
    }


    public RoboticHealthEnum getRoboticPetHealth() {
        return roboticPetHealth;
    }

    @Override
    public String toString() {
        return super.toString() + "RoboticPetModel [petModel=" + model + ", Manufacturer=" + manufacturer
                + ", petEnergyLevel="
                + energyLevel + ", petOilLevel=" + oilLevel + ", roboticPetHealth=" + roboticPetHealth + "]";
    }

}
