package com.example.befix.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DonateRequest {

    Long id_campaign;


    //số tiền donate
    BigDecimal sol;

    //key người dùng donate
    String publicKey;
}
