package com.example.befix.dto.mapper;


import com.example.befix.dto.CampaignDto;
import com.example.befix.dto.DonateDto;
import com.example.befix.entity.Campaign;
import com.example.befix.entity.Donate;
import com.example.befix.request.CampaignRequest;
import com.example.befix.request.DonateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.UUID;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CampaignMap {

    Campaign requestToEntity(CampaignRequest campaignRequest);
    DonateDto donateDto(Donate donate);

    List<DonateDto> donateDos(List<Donate> donates);

    CampaignDto campaignDto(Campaign campaign);

    List<CampaignDto> campaignDos(List<Campaign> campaign);

    Donate requestToEntity(DonateRequest donateRequest);




}
