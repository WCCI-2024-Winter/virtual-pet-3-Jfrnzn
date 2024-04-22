package org.wecancodeit.DTO;

import org.wecancodeit.Models.AdoptersModel;
import org.wecancodeit.Models.ShelterModel;
import org.wecancodeit.Models.Enums.AdoptionStatusEnum;
import org.wecancodeit.Models.Enums.PetTypeEnum;

public class AdopterDto {

    private long id;
    private String name;
    private String address1;
    private String address2;
    private String city;

    private String zip;
    private String state;
    private String phoneNumber;
    private String email;
    private String imageUrl;
    private PetTypeEnum preferredPetType;
    private AdoptionStatusEnum adoptionStatus;

    private ShelterModel shelterModel;
 

    public AdopterDto() {
        super();
    }

    public AdopterDto(AdoptersModel model) {
        this.id = model.getId();
        this.name = model.getName();
        this.address1 = model.getAddress1();
        this.address2 = model.getAddress2();
        this.city = model.getCity();
        this.zip = model.getZip();
        this.state = model.getName();
        this.phoneNumber = model.getPhoneNumber();
        this.email = model.getEmail();
        this.imageUrl = model.getImageUrl();
        this.preferredPetType = model.getPreferredPetType();
        this.adoptionStatus = model.getAdoptionStatus();
        this.shelterModel = model.getShelterModel();
       

    }

    public AdoptersModel convertToModel(){
        AdoptersModel model = new AdoptersModel(this.name,this.address1,this.address2,this.city,this.zip,this.state,this.phoneNumber,this.email,
        this.imageUrl,this.preferredPetType,this.adoptionStatus);
        return model;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public PetTypeEnum getPreferredPetType() {
        return preferredPetType;
    }

    public void setPreferredPetType(PetTypeEnum preferredPetType) {
        this.preferredPetType = preferredPetType;
    }

    public AdoptionStatusEnum getAdoptionStatus() {
        return adoptionStatus;
    }

    public void setAdoptionStatus(AdoptionStatusEnum adoptionStatus) {
        this.adoptionStatus = adoptionStatus;
    }

    public ShelterModel getShelterModel() {
        return shelterModel;
    }

    public void setShelterModel(ShelterModel shelterModel) {
        this.shelterModel = shelterModel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    public String getState() {
        return state;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String toString() {
        return "ContactModel [id=" + id + ", name=" + name + ", address1=" + address1 + ", address2=" + address2
                + ", city=" + city + ", zip=" + zip + ", state=" + state + ", phoneNumber=" + phoneNumber + ", email="
                + email + ", imageUrl=" + imageUrl + "]";
    }

}
