package org.wecancodeit.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
@Entity
@Table(name = "t_Volunteer")

public class VolunteerModel extends ContactModel {

    public VolunteerModel() {
        super();
    }

        public VolunteerModel(String name, String address1, String address2, String city, @Size(max = 10, min = 5) String zip,
            String state, String phonenumber, String email, String imageUrl) {
        super(name, address1, address2, city, zip, state, phonenumber, email, imageUrl);
       
    }

    
    
}
