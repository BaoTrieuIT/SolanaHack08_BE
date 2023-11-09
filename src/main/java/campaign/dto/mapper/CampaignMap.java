package campaign.dto.mapper;

import campaign.dto.CampaignDto;
import campaign.dto.DonateDto;
import campaign.entity.Campaign;
import campaign.entity.Donate;
import campaign.request.CampaignRequest;
import campaign.request.DonateRequest;
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

    List<DonateDto> donateDtos(List<Donate> donates);

    CampaignDto campaignDto(Campaign campaign);

    List<CampaignDto> campaignDtos(List<Campaign> campaign);

    Donate requestToEntity(DonateRequest donateRequest);




}
