package org.wecancodeit.DTO;

import org.wecancodeit.Models.ShelterModel;

public class ShelterLookUpDto {
    

    private long id;
    private String name;
    public ShelterLookUpDto() {
    }
    public ShelterLookUpDto(ShelterModel model) {
        this.id = model.getId();
        this.name = model.getName();
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    
}
