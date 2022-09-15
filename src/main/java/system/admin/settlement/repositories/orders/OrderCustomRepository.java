package system.admin.settlement.repositories.orders;

import system.admin.settlement.entities.Orders;

import java.util.List;

public interface OrderCustomRepository {
    public List<Orders> findOrdersByStoreOwnerId(Long storeOwnerId);
}
