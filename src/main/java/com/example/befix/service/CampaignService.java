package com.example.befix.service;


import com.example.befix.dto.CampaignDto;
import com.example.befix.request.CampaignRequest;
import com.example.befix.request.PageRequest;

import java.util.List;

public interface CampaignService {
    CampaignDto create(CampaignRequest campaignRequest);

    List<CampaignDto> findAllWhere(PageRequest pageRequest);

    List<CampaignDto> findAll(PageRequest pageRequest);

    CampaignDto finBy(Long id);
}
