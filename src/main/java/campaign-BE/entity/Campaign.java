package cuong.run.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "campaign")
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "author")
    private String author;

    @Column(name = "start_time")
    private Instant startTime;

    @Column(name = "end_time")
    private Instant endTime;

    @Column(name = "funded")
    private BigDecimal funded;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "image")
    private String image;

    @Column(name = "last_donation")
    private String lastDonation;

    @Column(name = "truong")
    private String truong;

    @OneToMany(mappedBy = "campaign")
    private Set<cuong.run.entity.Donate> donates = new LinkedHashSet<>();

}