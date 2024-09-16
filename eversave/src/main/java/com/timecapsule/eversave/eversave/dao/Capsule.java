package com.timecapsule.eversave.eversave.dao;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Capsule {
    private int id;
    @NotBlank
    private String title;
    private String description;
    @NotBlank
    private String date;
    @NotBlank
    private String time;
    private String location;
    private String image;
    private String video;
    @NotBlank
    private int userId;
}
