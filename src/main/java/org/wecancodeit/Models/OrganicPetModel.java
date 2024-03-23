package org.wecancodeit.Models;

import java.util.ArrayList;

import org.wecancodeit.Models.Enums.PetHealthEnum;
import org.wecancodeit.Models.Enums.PetMoodEnum;
import org.wecancodeit.Models.Enums.PetTempermentEnum;
import org.wecancodeit.Models.Enums.PetTypeEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

//*model for non-robot pets 
// id will pull from petmodel*/
@Entity
@Table(name = "t_OrganicPet")
public class OrganicPetModel extends PetModel {

    @Column(length = 50, nullable = false)
    private String breed;
    @Min(0)
    @Max(25)
    private int petAge;
    private PetHealthEnum petHealth;
    private PetMoodEnum petMood;
    private PetTempermentEnum petTemperment;
    private boolean petFixed;

    @ManyToOne
    private ShelterModel shelterModel;

    public OrganicPetModel() {
        super();

    }

    public OrganicPetModel(String name, PetTypeEnum petType, String imageUrl, String breed,
            int petAge, PetHealthEnum petHealth, PetMoodEnum petMood, PetTempermentEnum petTemperment,
            boolean petFixed, ArrayList<Long> scheduledTaskIds) {
        super(name, petType, imageUrl, scheduledTaskIds);
        this.breed = breed;
        this.petAge = petAge;
        this.petHealth = petHealth;
        this.petMood = petMood;
        this.petTemperment = petTemperment;
        this.petFixed = petFixed;
    }

    public String getPetBreed() {
        return breed;
    }

    public int getPetAge() {
        return petAge;
    }

    public PetHealthEnum getPetHealth() {
        return petHealth;
    }

    public PetMoodEnum getPetMood() {
        return petMood;
    }

    public PetTempermentEnum getPetTemperment() {
        return petTemperment;
    }

    public boolean isPetFixed() {
        return petFixed;
    }

    @Override
    public String toString() {
        return super.toString() + "OrganicPetModel [petBreed=" + breed + ", petAge=" + petAge + ", petHealth="
                + petHealth
                + ", petMood=" + petMood + ", petTemperment=" + petTemperment + ", petFixed=" + petFixed
                + ", shelterModel=" + shelterModel + "]";
    }

}
