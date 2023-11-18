package com.example.befix.repository;

import com.example.befix.entity.Donate;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DonateRepository extends JpaRepository<Donate, Long> {
    @Query("""
        select d from Donate  d
        where d.publicKey = :publickey
    """)
    List<Donate> userGetAll(String publickey);

    @Query("""
        select d from Donate  d
        where d.campaign.id = :id
    """)
    List<Donate> campaignGetAllDonate(Long id);
}
