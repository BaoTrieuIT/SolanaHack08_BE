package campaign.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class PublicKeyDto {
    //số lượng dự án donate
    int countProject;
    //tổng s tiền donate
    BigDecimal sumDonate;
}
