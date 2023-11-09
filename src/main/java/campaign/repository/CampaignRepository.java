package campaign.repository;

import campaign.entity.Campaign;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {

    @Query("""
        select c from Campaign c
        where c.endTime > current_date
    """)
    List<Campaign> getAllWhere(Pageable pageable);

    @Query("""
        select c from Campaign c
    """)
    List<Campaign> getAll(Pageable pageable);

    @Modifying
    @Query("""
        update Campaign c
        set c.total = c.total + :total
        where c.id = :id
    """)
    void donate(Long id, BigDecimal total);

    @Query("""
        select c.id from Campaign c join c.donates d
        where d.publicKey = :publickey
        group by c.id
    """)
    List<Long> tkTotalProjectDonate(String publickey);

    @Query("""
        select cast(sum(d.sol) as BIGDECIMAL)
        from Campaign c join c.donates d
        where d.publicKey = :publickey
        group by d.publicKey
    """)
    BigDecimal tkTotalAmountDonateProject(String publickey);
}
