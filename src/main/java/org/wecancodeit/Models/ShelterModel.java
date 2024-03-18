package org.wecancodeit.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "t_Shelter")

public class ShelterModel extends ContactModel{
    private String website;

    public ShelterModel(){

    }

    public ShelterModel(String name, String address1, String address2, String city, @Size(max = 10, min = 5) String zip,
            String state, String phonenumber, String email, String imageUrl, String website) {
        super(name, address1, address2, city, zip, state, phonenumber, email, imageUrl);
        this.website = website;
    }

    public ShelterModel(String website) {
        this.website = website;
    }

    public String getWebsite() {
        return website;
    }


    
    
    
}
