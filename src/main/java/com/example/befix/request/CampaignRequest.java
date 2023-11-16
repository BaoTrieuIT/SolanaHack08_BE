package com.example.befix.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
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


    private LocalDate endTime;

    @NotNull(message = "Max not null")
    @DecimalMin(value = "0.0", inclusive = false, message = "The value \"Max\" entered must be greater than 0.0")
    @DecimalMax(value = "1000000000.0", inclusive = false, message = "The value \"Max\" entered must be less than 1000000000.0")
    BigDecimal max;


    @NotBlank(message = "Image not blank")
    private String image;
}
