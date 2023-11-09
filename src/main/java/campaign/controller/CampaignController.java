package campaign.controller;

import campaign.dto.CampaignDto;
import campaign.request.CampaignRequest;
import campaign.request.PageRequest;
import campaign.service.CampaignService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/campaign")
@RequiredArgsConstructor
public class CampaignController {
    final CampaignService campaignService;

    @PostMapping("/create")
    public CampaignDto create(@Valid @RequestBody CampaignRequest campaignRequest){
        return campaignService.create(campaignRequest);
    }

    //lấy ra tất cả ự án với điều kiện ngày kêết thúc phải lớn hơn ngày hiện tại
    @PostMapping("/get/all/where")
    public List<CampaignDto> getallwhere(@RequestBody PageRequest pageRequest){
        return campaignService.findAllwhere(pageRequest);
    }

    //lấy ra tất cả ự án
    @PostMapping("/get/all")
    public List<CampaignDto> getall(@RequestBody PageRequest pageRequest){
        return campaignService.findAll(pageRequest);
    }

    //xem thông tin chi tiết của dự án
    @GetMapping("/find")
    public CampaignDto findby(@Param("id") Long id){
        return campaignService.findby(id);
    }

    //

}
