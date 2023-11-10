package com.example.befix.service;


import com.example.befix.dto.DonateDto;
import com.example.befix.dto.PublicKeyDto;
import com.example.befix.request.CampaignDonateRequest;
import com.example.befix.request.DonateRequest;
import com.example.befix.request.PublicKeyRequest;

import java.util.List;

public interface DonateService {
    void donate(DonateRequest donateRequest);

    PublicKeyDto getPublicKeyDto(String publickey);

    List<DonateDto> userGetAll(PublicKeyRequest publicKeyRequest);

    List<DonateDto> campaignGetAllDonate(CampaignDonateRequest campaignDonateRequest);
}
