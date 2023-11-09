package campaign.controller;

import campaign.dto.DonateDto;
import campaign.dto.PublicKeyDto;
import campaign.request.CampaignDonateRequest;
import campaign.request.DonateRequest;
import campaign.request.PublicKeyRequest;
import campaign.service.DonateService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/donate")
@RequiredArgsConstructor
public class DonateController {
    final DonateService donateService;
    @PostMapping()
    public void donate(@RequestBody DonateRequest donateRequest){
        donateService.donate(donateRequest);
    }

    //xem dc người đó đã donate bao nhiêu cho tất cả d án và số lượng d án đ donate
    @GetMapping("/publickey")
    public PublicKeyDto publicKeyDto(@Param("publickey") String publickey){
        return donateService.getPublicKeyDto(publickey);
    }


    //Danh sách các dự án đã donate
    @PostMapping("/publickey/find/all")
    public List<DonateDto> userGetAll(@RequestBody PublicKeyRequest publicKeyRequest){
        return donateService.userGetAll(publicKeyRequest);
    }

    //xem danh sách các số người đã donate vào dự án theo id
    @PostMapping("/campaign/get/all")
    public List<DonateDto> campaignGetUserDonate(@RequestBody CampaignDonateRequest campaignDonateRequest){
        return donateService.campaignGetAllDonate(campaignDonateRequest);
    }
}
