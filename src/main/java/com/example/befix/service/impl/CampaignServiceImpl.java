package com.example.befix.service.impl;


import com.example.befix.dto.CampaignDto;
import com.example.befix.dto.mapper.CampaignMap;
import com.example.befix.entity.Campaign;
import com.example.befix.repository.CampaignRepository;
import com.example.befix.request.CampaignRequest;
import com.example.befix.request.PageRequest;
import com.example.befix.service.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CampaignServiceImpl implements CampaignService {
    final CampaignRepository campaignRepository;
    final CampaignMap campaignMap;

    @Override
    public CampaignDto create(CampaignRequest campaignRequest) {
        Optional<Campaign> campaignOptional = campaignRepository.findById(campaignRequest.getId());
        Campaign campaign = campaignMap.requestToEntity(campaignRequest);
        if (campaignOptional.isPresent()) {
            campaign.setTotal(campaignOptional.get().getTotal());
        } else {
            campaign.setTotal(BigDecimal.ZERO);
        }
        Campaign campaignSave = campaignRepository.save(campaign);
        return campaignMap.campaignDto(campaignSave);
    }

    @Cacheable(value = "findAllWhere")
    @Override
    public List<CampaignDto> findAllWhere(PageRequest pageRequest) {
        List<Campaign> campaigns = campaignRepository.getAllWhere(org.springframework.data.domain.PageRequest.of(pageRequest.getPage() - 1, pageRequest.getSize()));
        return campaignMap.campaignDos(campaigns);
    }

    @Override
    public List<CampaignDto> findAll(PageRequest pageRequest) {
        List<Campaign> campaigns = campaignRepository.getAll(org.springframework.data.domain.PageRequest.of(pageRequest.getPage() - 1, pageRequest.getSize()));
        return campaignMap.campaignDos(campaigns);
    }

    @Override
    public CampaignDto finBy(Long id) {
        Campaign campaign = campaignRepository.findById(id).orElse(null);
        return campaignMap.campaignDto(campaign);
    }
}
