package  com.example.befix.controller;


import com.example.befix.dto.DonateDto;
import com.example.befix.dto.PublicKeyDto;
import com.example.befix.request.CampaignDonateRequest;
import com.example.befix.request.DonateRequest;
import com.example.befix.request.PublicKeyRequest;
import com.example.befix.service.DonateService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/donate")
@RequiredArgsConstructor
@CrossOrigin("*")
public class DonateController {
    final DonateService donateService;
    @PostMapping()
    public void donate(@RequestBody DonateRequest donateRequest){
        donateService.donate(donateRequest);
    }

    //xem dc người đó đã donate bao nhiêu cho tất cả d án và số lượng d án đ donate
    @GetMapping("/publicly")
    public PublicKeyDto publicKeyDto(@Param("publicly") String publicly){
        return donateService.getPublicKeyDto(publicly);
    }


    //Danh sách các dự án đã donate
    @PostMapping("/publicly-find-all")
    public List<DonateDto> userGetAll(@RequestBody PublicKeyRequest publicKeyRequest){
        return donateService.userGetAll(publicKeyRequest);
    }

    //xem danh sách các số người đã donate vào dự án theo id
    @PostMapping("/campaign-get-all")
    public List<DonateDto> campaignGetUserDonate(@RequestBody CampaignDonateRequest campaignDonateRequest){
        return donateService.campaignGetAllDonate(campaignDonateRequest);
    }
}
