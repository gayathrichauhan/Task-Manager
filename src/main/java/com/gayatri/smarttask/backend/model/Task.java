package com.gayatri.smarttask.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Task {

    @Enumerated(EnumType.STRING)
    private Status status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//this auto increments value
    private Long id;

    @NotBlank(message = "Title cannot be empty")//used for validation
    @Size(min=3,max=100)
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
