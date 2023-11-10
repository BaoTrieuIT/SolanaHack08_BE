package com.example.befix.dto.mapper;


import com.example.befix.dto.CampaignDto;
import com.example.befix.dto.DonateDto;
import com.example.befix.entity.Campaign;
import com.example.befix.entity.Donate;
import com.example.befix.request.CampaignRequest;
import com.example.befix.request.DonateRequest;
import org.mapstruct.Mapper;

import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring",
        imports = {UUID.class, Instant.class, List.class, ArrayList.class, LinkedHashSet.class})
public interface CampaignMap {

    Campaign requestToEntity(CampaignRequest campaignRequest);
    DonateDto donateDto(Donate donate);

    List<DonateDto> donateDos(List<Donate> donates);

    CampaignDto campaignDto(Campaign campaign);

    List<CampaignDto> campaignDos(List<Campaign> campaign);

    Donate requestToEntity(DonateRequest donateRequest);




}
