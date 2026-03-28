package com.gayatri.smarttask.backend.model;

import jakarta.persistence.*;

@Entity
public class Task {

    @Enumerated(EnumType.STRING)
    private Status status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//this auto increments value
    private Long id;
    private String title;
    private String description;


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

    public Status getStatus(){
        return status;
    }
    public void setStatus(Status status){
        this.status=status;
    }


}
