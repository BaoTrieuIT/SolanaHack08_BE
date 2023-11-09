package campaign.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PublicKeyRequest {
    String publickey;

    PageRequest pageRequest;
}
