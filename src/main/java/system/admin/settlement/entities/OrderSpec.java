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
@Table(name = "orders_spec")
public class OrderSpec {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="orders_id")
    @ToString.Exclude
    private Orders orders;

    private OrderType orderType;

    private Long price;

}
