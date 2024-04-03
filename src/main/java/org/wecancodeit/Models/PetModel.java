package org.wecancodeit.Models;

import java.util.ArrayList;

import org.wecancodeit.Models.Enums.PetTypeEnum;
import jakarta.persistence.*;

//*base pet class */
@MappedSuperclass
public abstract class PetModel {
    @Id
    @GeneratedValue() // *generate an id for each pet */
    private long id;
    @Column(length = 50, nullable = false)
    private String name;
    private PetTypeEnum petType;
    private String imageUrl;
    private ArrayList<Long> scheduledTaskIds;

    public PetModel() {
    }

    public PetModel(String name, PetTypeEnum petType, String imageUrl, ArrayList<Long> scheduledTaskIds) {
        this.name = name;
        this.petType = petType;
        this.imageUrl = imageUrl;
       
        this.scheduledTaskIds = scheduledTaskIds;
    }
    

    public void setId(long id) {
        this.id = id;
    }



    public ArrayList<Long> getScheduledTaskIds() {
        return scheduledTaskIds;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PetTypeEnum getPetType() {
        return petType;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String toString() {
        return "PetModel [id=" + id + ", name=" + name + ", petType=" + petType + ", imageUrl=" + imageUrl + "]";
    }

}