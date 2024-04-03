package org.wecancodeit.Models;

import org.wecancodeit.Models.Enums.AdoptionStatusEnum;
import org.wecancodeit.Models.Enums.PetTypeEnum;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "t_Adopters")
public class AdoptersModel extends ContactModel {

    public PetTypeEnum preferredPetType;
    private AdoptionStatusEnum adoptionStatus;

    @ManyToOne
    private ShelterModel shelterModel;

    public AdoptersModel() {
        super();
    }

    /**
     * 
     * @param name
     * @param address1
     * @param address2
     * @param city
     * @param zip
     * @param state
     * @param phonenumber
     * @param email
     * @param imageUrl
     * @param petType
     * @param adoptionStatus
     */

    public AdoptersModel(String name, String address1, String address2, String city,
            @Size(max = 10, min = 5) String zip,
            String state, String phonenumber, String email, String imageUrl, PetTypeEnum petType,
            AdoptionStatusEnum adoptionStatus) {
        super(name, address1, address2, city, zip, state, phonenumber, email, imageUrl);
        this.preferredPetType = petType;
        this.adoptionStatus = adoptionStatus;
    }
    @JsonIgnore
    public void saveShelterModel(ShelterModel shelterModel){
        this.shelterModel = shelterModel;
    }

    public AdoptersModel(PetTypeEnum petType) {
        this.preferredPetType = petType;
    }

    public PetTypeEnum getPetType() {
        return preferredPetType;
    }

    @Override
    public String toString() {
        return "AdoptersModel [preferredPetType=" + preferredPetType + ", adoptionStatus=" + adoptionStatus
                + ", shelterModel=" + shelterModel + "]";
    }

}
