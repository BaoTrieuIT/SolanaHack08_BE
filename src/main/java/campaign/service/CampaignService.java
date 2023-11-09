package campaign.service;

import campaign.dto.CampaignDto;
import campaign.request.CampaignRequest;
import campaign.request.PageRequest;
import java.util.List;

public interface CampaignService {
    CampaignDto create(CampaignRequest campaignRequest);

    List<CampaignDto> findAllwhere(PageRequest pageRequest);

    List<CampaignDto> findAll(PageRequest pageRequest);

    CampaignDto findby(Long id);
}
