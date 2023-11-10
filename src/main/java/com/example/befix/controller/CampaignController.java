package  com.example.befix.controller;


import com.example.befix.dto.CampaignDto;
import com.example.befix.request.CampaignRequest;
import com.example.befix.request.PageRequest;
import com.example.befix.service.CampaignService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/campaign")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CampaignController {
    final CampaignService campaignService;

    @PostMapping("/create")
    public CampaignDto create(@Valid @RequestBody CampaignRequest campaignRequest){
        return campaignService.create(campaignRequest);
    }

    //lấy ra tất cả ự án với điều kiện ngày kêết thúc phải lớn hơn ngày hiện tại
    @GetMapping("/get-all-where")
    public List<CampaignDto> getAllWhere(@ModelAttribute PageRequest pageRequest){
        return campaignService.findAllWhere(pageRequest);
    }

    //lấy ra tất cả ự án
    @GetMapping("/get-all")
    public List<CampaignDto> getAll(@ModelAttribute PageRequest pageRequest){
        return campaignService.findAll(pageRequest);
    }

    //xem thông tin chi tiết của dự án
    @GetMapping("/find")
    public CampaignDto findBy(@Param("id") Long id){
        return campaignService.finBy(id);
    }

    //

}
