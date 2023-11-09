package campaign.dto.mapper;

import campaign.dto.CampaignDto;
import campaign.dto.DonateDto;
import campaign.entity.Campaign;
import campaign.entity.Donate;
import campaign.request.CampaignRequest;
import campaign.request.DonateRequest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-09T16:13:30+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.4.1 (Oracle Corporation)"
)
@Component
public class CampaignMapImpl implements CampaignMap {

    @Override
    public Campaign requestToEntity(CampaignRequest campaignRequest) {
        if ( campaignRequest == null ) {
            return null;
        }

        Campaign.CampaignBuilder campaign = Campaign.builder();

        campaign.id( campaignRequest.getId() );
        campaign.title( campaignRequest.getTitle() );
        campaign.description( campaignRequest.getDescription() );
        campaign.startTime( campaignRequest.getStartTime() );
        campaign.endTime( campaignRequest.getEndTime() );
        campaign.image( campaignRequest.getImage() );

        return campaign.build();
    }

    @Override
    public DonateDto donateDto(Donate donate) {
        if ( donate == null ) {
            return null;
        }

        DonateDto donateDto = new DonateDto();

        donateDto.setId( donate.getId() );
        donateDto.setSol( donate.getSol() );
        donateDto.setDateDonate( donate.getDateDonate() );
        donateDto.setPublicKey( donate.getPublicKey() );
        donateDto.setCampaign( campaignDto( donate.getCampaign() ) );

        return donateDto;
    }

    @Override
    public List<DonateDto> donateDtos(List<Donate> donates) {
        if ( donates == null ) {
            return null;
        }

        List<DonateDto> list = new ArrayList<DonateDto>( donates.size() );
        for ( Donate donate : donates ) {
            list.add( donateDto( donate ) );
        }

        return list;
    }

    @Override
    public CampaignDto campaignDto(Campaign campaign) {
        if ( campaign == null ) {
            return null;
        }

        CampaignDto campaignDto = new CampaignDto();

        campaignDto.setId( campaign.getId() );
        campaignDto.setTitle( campaign.getTitle() );
        campaignDto.setDescription( campaign.getDescription() );
        campaignDto.setStartTime( campaign.getStartTime() );
        campaignDto.setEndTime( campaign.getEndTime() );
        campaignDto.setTotal( campaign.getTotal() );
        campaignDto.setImage( campaign.getImage() );

        return campaignDto;
    }

    @Override
    public List<CampaignDto> campaignDtos(List<Campaign> campaign) {
        if ( campaign == null ) {
            return null;
        }

        List<CampaignDto> list = new ArrayList<CampaignDto>( campaign.size() );
        for ( Campaign campaign1 : campaign ) {
            list.add( campaignDto( campaign1 ) );
        }

        return list;
    }

    @Override
    public Donate requestToEntity(DonateRequest donateRequest) {
        if ( donateRequest == null ) {
            return null;
        }

        Donate donate = new Donate();

        donate.setSol( donateRequest.getSol() );
        donate.setPublicKey( donateRequest.getPublicKey() );

        return donate;
    }
}
