package org.wecancodeit.Models;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.*;


@Entity
@Table(name = "t_Shelter")

public class ShelterModel extends ContactModel {
    private String website;

    @OneToMany(mappedBy = "shelterModel", cascade = CascadeType.ALL)
    private Collection<OrganicPetModel> organicPets;

    @OneToMany(mappedBy = "shelterModel", cascade = CascadeType.ALL)
    private Collection<RoboticPetModel> roboticPets;

    @OneToMany(mappedBy = "shelterModel", cascade = CascadeType.ALL)
    private Collection<AdoptersModel> adoptersModel;

    @ManyToMany()
    @JoinTable(name = "shelter_volunteer", joinColumns = @JoinColumn(name = "shelter_id"), inverseJoinColumns = @JoinColumn(name = "volunteer_id"))
    private Collection<VolunteerModel> volunteerModel;

    public ShelterModel() {
        super();

    }

    public ShelterModel(String name, String address1, String address2, String city, String zip,
            String state, String phoneNumber, String email, String imageUrl, String website) {
        super(name, address1, address2, city, zip, state, phoneNumber, email, imageUrl);
        this.website = website;
        this.organicPets = new ArrayList<>();
        this.roboticPets = new ArrayList<>();

    }

    public ShelterModel(String website) {
        this.website = website;
    }

    public String getWebsite() {
        return website;
    }

    public Collection<OrganicPetModel> getOrganicPets() {
        return organicPets;
    }

    public Collection<RoboticPetModel> getRoboticPets() {
        return roboticPets;
    }

    public Collection<AdoptersModel> getAdoptersModel() {
        return adoptersModel;
    }

    public Collection<VolunteerModel> getVolunteerModel() {
        return volunteerModel;
    }

    @Override
    public String toString() {
        return super.toString() + "ShelterModel [website=" + website + ", organicPets=" + organicPets + ", roboticPets="
                + roboticPets + "]";
    }

}
