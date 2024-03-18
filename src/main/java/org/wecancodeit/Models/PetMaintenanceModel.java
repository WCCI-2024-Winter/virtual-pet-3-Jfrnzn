package org.wecancodeit.Models;

import org.wecancodeit.Models.Enums.PetTaskEnum;
import org.wecancodeit.Models.Enums.PetTypeEnum;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "t_maintenance")
public class PetMaintenanceModel {

    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 50, nullable = false)
    private String name;
    @Min(0)
    @Max(1464)
    private int frequency;
    private PetTypeEnum petType;
    private PetTaskEnum effectedProperty;

    public PetMaintenanceModel() {
    }

    public PetMaintenanceModel(String name, @Min(0) @Max(1464) int frequency, PetTypeEnum petType,
            PetTaskEnum effectedProperty) {
        this.name = name;
        this.frequency = frequency;
        this.petType = petType;
        this.effectedProperty = effectedProperty;
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

    public int getFrequency() {
        return frequency;
    }

    public PetTypeEnum getPetType() {
        return petType;
    }

    public PetTaskEnum getEffectedProperty() {
        return effectedProperty;
    }

    @Override
    public String toString() {
        return "PetMaintenanceModel [id=" + id + ", name=" + name + ", frequency=" + frequency + ", petType=" + petType
                + ", effectedProperty=" + effectedProperty + "]";
    }

}
