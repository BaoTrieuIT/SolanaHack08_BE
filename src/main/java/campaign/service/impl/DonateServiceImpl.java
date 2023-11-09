package campaign.service.impl;

import campaign.dto.DonateDto;
import campaign.dto.PublicKeyDto;
import campaign.dto.mapper.CampaignMap;
import campaign.entity.Campaign;
import campaign.entity.Donate;
import campaign.repository.CampaignRepository;
import campaign.repository.DonateRepository;
import campaign.request.CampaignDonateRequest;
import campaign.request.DonateRequest;
import campaign.request.PublicKeyRequest;
import campaign.service.DonateService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;


@Service
@RequiredArgsConstructor
public class DonateServiceImpl implements DonateService {
    final CampaignMap campaignMap;
    final DonateRepository donateRepository;
    final CampaignRepository campaignRepository;
    @Transactional
    @Override
    public void donate(DonateRequest donateRequest) {
        Donate donate = campaignMap.requestToEntity(donateRequest);
        Campaign campaign = Campaign.builder().id(donateRequest.getId_campaign()).build();
        donate.setCampaign(campaign);
        donateRepository.save(donate);
        campaignRepository.donate(donateRequest.getId_campaign(), donateRequest.getSol());
    }

    @Override
    public PublicKeyDto getPublicKeyDto(String publickey) {
        BigDecimal amount = campaignRepository.tkTotalAmountDonateProject(publickey);
        List<Long> count = campaignRepository.tkTotalProjectDonate(publickey);
        return PublicKeyDto
                .builder()
                .countProject(count.size())
                .sumDonate(amount)
                .build();
    }

    @Override
    public List<DonateDto> userGetAll(PublicKeyRequest publicKeyRequest) {
        Pageable pageable = PageRequest.of(publicKeyRequest.getPageRequest().getPage()-1, publicKeyRequest.getPageRequest().getSize());
        List<Donate> donates = donateRepository.userGetAll(publicKeyRequest.getPublickey(),pageable);
        return campaignMap.donateDtos(donates);
    }

    @Override
    public List<DonateDto> campaignGetAllDonate(CampaignDonateRequest campaignDonateRequest) {
        Pageable pageable = PageRequest.of(campaignDonateRequest.getPageRequest().getPage()-1, campaignDonateRequest.getPageRequest().getSize());
        List<Donate> donates = donateRepository.campaignGetAllDonate(campaignDonateRequest.getId(),pageable);
        return campaignMap.donateDtos(donates);
    }
}
