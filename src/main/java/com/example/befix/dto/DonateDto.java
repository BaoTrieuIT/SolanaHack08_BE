package com.example.befix.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
public class DonateDto {

    private Long id;

    private BigDecimal sol;

    private Instant dateDonate;

    private String publicKey;

    CampaignDto campaign;

}
