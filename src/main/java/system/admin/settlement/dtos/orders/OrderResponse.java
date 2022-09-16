package system.admin.settlement.dtos.orders;

import lombok.*;
import system.admin.settlement.entities.Orders;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {

    private Long id;

    private LocalDateTime createdDate;

    @Builder(builderMethodName = "builderByOrders", builderClassName = "OrdersBuilder")
    public OrderResponse(Orders orders) {
        id = orders.getId();
        createdDate = orders.getCreatedDate();
    }

}
