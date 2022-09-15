package system.admin.settlement.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import system.admin.settlement.entities.Orders;
import system.admin.settlement.repositories.orders.OrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void getOrdersByStoreOwnerId(Long storeOwnerId) {
        List<Orders> ordersList = orderRepository.findOrdersByStoreOwnerId(storeOwnerId);
    }
}
