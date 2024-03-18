package org.wecancodeit.Models;

import org.wecancodeit.Models.Enums.PetHealthEnum;
import org.wecancodeit.Models.Enums.PetMoodEnum;
import org.wecancodeit.Models.Enums.PetTempermentEnum;
import org.wecancodeit.Models.Enums.PetTypeEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

//*model for non-robot pets 
// id will pull from petmodel*/
@Entity
@Table(name = "t_OrganicPet")
public class OrganicPetModel extends PetModel {
    public OrganicPetModel(String name, PetTypeEnum petType, String imageUrl) {
        super(name, petType, imageUrl);
        // TODO Auto-generated constructor stub
    }

    @Column(length = 50, nullable = false)
    private String petBreed;
    @Min(0)
    @Max(25)
    private int petAge;
    private PetHealthEnum petHealth;
    private PetMoodEnum petMood;
    private PetTempermentEnum petTemperment;
    private boolean petFixed;

    public OrganicPetModel(String name, PetTypeEnum petType, String imageUrl, String petBreed,
            @Min(0) @Max(25) int petAge, PetHealthEnum petHealth, PetMoodEnum petMood, PetTempermentEnum petTemperment,
            boolean petFixed) {
        super(name, petType, imageUrl);
        this.petBreed = petBreed;
        this.petAge = petAge;
        this.petHealth = petHealth;
        this.petMood = petMood;
        this.petTemperment = petTemperment;
        this.petFixed = petFixed;
    }

    public String getPetBreed() {
        return petBreed;
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

}
