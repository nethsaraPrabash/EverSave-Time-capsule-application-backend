package com.timecapsule.eversave.eversave.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CapsuleEntity {

    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String description;
    private String date;
    private String time;
    private String location;
    private String image;
    private String video;
    private int userId;



}
