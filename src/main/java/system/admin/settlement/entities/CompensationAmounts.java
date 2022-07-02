package system.admin.settlement.entities;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import system.admin.settlement.dtos.enums.CompReason;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class CompensationAmounts {

    //보상금액은 대상 업주, 보상사유, 보상날짜, 보상금액을 가짐

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "comp_id")
    private StoreOwners storeOwners;

    private CompReason compReason;

    private String compReasonSpec;

    private Long price;

    @CreatedDate
    private LocalDateTime requestDate;

    private LocalDateTime compDate;


}
