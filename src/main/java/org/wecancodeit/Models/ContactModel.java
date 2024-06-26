package org.wecancodeit.Models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Size;

@MappedSuperclass
public abstract class ContactModel {
    @Id
    @GeneratedValue()
    private long id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 150, nullable = true)
    private String address1;
    @Column(length = 150, nullable = true)
    private String address2;
    @Column(length = 50, nullable = true)
    private String city;
    @Column(length = 10, nullable = true)
    /**removed the size constrait so zip can be null  */
    // @Size(max = 10, min = 5)
    private String zip;
    @Column(length = 2, nullable = true)
    private String state;
    @Column(length = 10, nullable = true)
    private String phoneNumber;
    @Column(length = 50, nullable = true)
    private String email;

    private String imageUrl;

    public ContactModel() {
    }

    public ContactModel(String name, String address1, String address2, String city, @Size(max = 10, min = 5) String zip,
            String state, String phoneNumber, String email, String imageUrl) {
        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.zip = zip;
        this.state = state;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.imageUrl = imageUrl;
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
