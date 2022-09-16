package system.admin.settlement.repositories.orders;

import system.admin.settlement.entities.Orders;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderCustomRepository {
    List<Orders> findOrdersByStoreOwnerId(Long storeOwnerId);

    List<Orders> findOrdersByRegDate(LocalDateTime regDateTime);
}
