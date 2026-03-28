package com.gayatri.smarttask.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {
    @Id//represents primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//this auto increments value
    private Long id;
    private String title;
    private String description;
    private String status;

    public Long getId(){//getting id
        return id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status=status;
    }


}
