package system.admin.settlement.entities;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.FetchType.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    private LocalDateTime createdDate;

    //todo : 아이템
    @OneToMany(mappedBy = "order")
    private List<Items> itemsList;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="owner_id")
    private StoreOwners storeOwners;

    private List<OrderSpec> orderSpecList;

}