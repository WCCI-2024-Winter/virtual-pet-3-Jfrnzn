package org.wecancodeit.Models;

import org.wecancodeit.Models.Enums.AdoptionStatusEnum;
import org.wecancodeit.Models.Enums.PetTypeEnum;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_Adopters")
public class AdoptersModel extends ContactModel {

    private PetTypeEnum preferredPetType;
    private AdoptionStatusEnum adoptionStatus;

    @ManyToOne
    private ShelterModel shelterModel;

    public AdoptersModel() {
    }

    public AdoptersModel(String name, String address1, String address2, String city,
            /** @Size(max = 10, min = 5) */
            String zip, String state, String phoneNumber, String email, String imageUrl,
            PetTypeEnum preferredPetType, AdoptionStatusEnum adoptionStatus) {
        super(name, address1, address2, city, zip, state, phoneNumber, email, imageUrl);
        this.preferredPetType = preferredPetType;
        this.adoptionStatus = adoptionStatus;

    }

    public PetTypeEnum getPreferredPetType() {
        return preferredPetType;
    }

    public AdoptionStatusEnum getAdoptionStatus() {
        return adoptionStatus;
    }

    public ShelterModel getShelterModel() {
        return shelterModel;
    }

    @JsonIgnore
    public void setShelterModel(ShelterModel shelterModel) {
        this.shelterModel = shelterModel;
    }

}
