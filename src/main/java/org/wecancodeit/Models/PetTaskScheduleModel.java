package org.wecancodeit.Models;

import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "t_Schedule")
public class PetTaskScheduleModel {
    @Id
    @GeneratedValue()
    private long id;

    private long VolunteerId;
    private long petId;
    private long taskId;

    private Date nextScheduledTime;

    public PetTaskScheduleModel() {
    }

    public PetTaskScheduleModel(long volunteerId, long petId, long taskId, Date nextScheduledTime) {
        VolunteerId = volunteerId;
        this.petId = petId;
        this.taskId = taskId;
        this.nextScheduledTime = nextScheduledTime;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public long getVolunteerId() {
        return VolunteerId;
    }

    public long getPetId() {
        return petId;
    }

    public long getTaskId() {
        return taskId;
    }

    public Date getNextScheduledTime() {
        return nextScheduledTime;
    }

    @Override
    public String toString() {
        return "ScheduleModel [id=" + id + ", VolunteerId=" + VolunteerId + ", petId=" + petId + ", taskId=" + taskId
                + ", nextScheduledTime=" + nextScheduledTime + "]";
    }



}
