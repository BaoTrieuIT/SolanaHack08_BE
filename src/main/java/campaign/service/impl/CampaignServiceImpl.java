package campaign.service.impl;

import campaign.dto.CampaignDto;
import campaign.dto.mapper.CampaignMap;
import campaign.entity.Campaign;
import campaign.repository.CampaignRepository;
import campaign.request.CampaignRequest;
import campaign.request.PageRequest;
import campaign.service.CampaignService;
import lombok.RequiredArgsConstructor;
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
        if(campaignOptional.isPresent()){
            campaign.setTotal(campaignOptional.get().getTotal());
        }else{
            campaign.setTotal(BigDecimal.ZERO);
        }
        Campaign campaignSave = campaignRepository.save(campaign);
        return campaignMap.campaignDto(campaignSave);
    }

    @Override
    public List<CampaignDto> findAllwhere(PageRequest pageRequest) {
        List<Campaign> campaigns = campaignRepository.getAllWhere(org.springframework.data.domain.PageRequest.of(pageRequest.getPage()-1, pageRequest.getSize()));
        return campaignMap.campaignDtos(campaigns);
    }

    @Override
    public List<CampaignDto> findAll(PageRequest pageRequest) {
        List<Campaign> campaigns = campaignRepository.getAll(org.springframework.data.domain.PageRequest.of(pageRequest.getPage()-1, pageRequest.getSize()));
        return campaignMap.campaignDtos(campaigns);
    }

    @Override
    public CampaignDto findby(Long id) {
        Campaign campaign = campaignRepository.findById(id).orElse(null);
        return campaignMap.campaignDto(campaign);
    }
}
