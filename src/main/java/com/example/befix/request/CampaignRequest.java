package com.example.befix.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
public class CampaignRequest {
    //nếu không truyền là create. Có id là update
    private Long id;


    @NotBlank(message = "Title not blank")
    @Length(min = 5, message = "Enter a Title that must be longer than 5 characters")
    private String title;

    @NotBlank(message = "Description not blank")
    @Length(min = 5, message = "Enter a description that must be longer than 5 characters")
    private String description;


    private LocalDate startTime = LocalDate.now();

    @NotNull(message = "End_time not null")
    private LocalDate endTime;


    @NotBlank(message = "Image not blank")
    private String image;
}
