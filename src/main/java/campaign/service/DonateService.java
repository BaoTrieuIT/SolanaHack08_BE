package campaign.service;

import campaign.dto.DonateDto;
import campaign.dto.PublicKeyDto;
import campaign.request.CampaignDonateRequest;
import campaign.request.DonateRequest;
import campaign.request.PublicKeyRequest;

import java.util.List;

public interface DonateService {
    void donate(DonateRequest donateRequest);

    PublicKeyDto getPublicKeyDto(String publickey);

    List<DonateDto> userGetAll(PublicKeyRequest publicKeyRequest);

    List<DonateDto> campaignGetAllDonate(CampaignDonateRequest campaignDonateRequest);
}
