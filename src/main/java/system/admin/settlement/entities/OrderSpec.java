package system.admin.settlement.entities;

import lombok.*;
import system.admin.settlement.dtos.enums.OrderType;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class OrderSpec {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="orders_id")
    private Orders orders;

    private OrderType orderType;

    private Long price;

}
