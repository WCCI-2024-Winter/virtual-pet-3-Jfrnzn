package org.wecancodeit.Models;

import org.wecancodeit.Models.Enums.PetTypeEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "t_Adopters")
public class AdoptersModel extends ContactModel {

    public PetTypeEnum preferredPetType;

    @ManyToOne
    private ShelterModel shelterModel;

    public AdoptersModel() {
        super();
    }

    public AdoptersModel(String name, String address1, String address2, String city,
            @Size(max = 10, min = 5) String zip,
            String state, String phonenumber, String email, String imageUrl, PetTypeEnum petType) {
        super(name, address1, address2, city, zip, state, phonenumber, email, imageUrl);
        this.preferredPetType = petType;
    }

    public AdoptersModel(PetTypeEnum petType) {
        this.preferredPetType = petType;
    }

    public PetTypeEnum getPetType() {
        return preferredPetType;
    }

    @Override
    public String toString() {
        return "AdoptersModel [petType=" + preferredPetType + "]";
    }

}
