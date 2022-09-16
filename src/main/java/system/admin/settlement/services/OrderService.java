package system.admin.settlement.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import system.admin.settlement.dtos.orders.OrderResponse;
import system.admin.settlement.entities.Orders;
import system.admin.settlement.repositories.orders.OrderRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Optional<List<OrderResponse>> getOrdersByStoreOwnerId(Long storeOwnerId) {
        List<Orders> ordersList = orderRepository.findOrdersByStoreOwnerId(storeOwnerId);

        if (ordersList.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(
                ordersList.stream()
                .map(orders ->
                        OrderResponse.builderByOrders().orders(orders).build())
                .collect(Collectors.toList())
        );

    }

    public Optional<List<OrderResponse>> getOrdersByRegDate(LocalDateTime regDateTime) {

        List<Orders> ordersList = orderRepository.findOrdersByRegDate(regDateTime);

        if (ordersList.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(
                ordersList.stream()
                .map(orders ->
                        OrderResponse.builderByOrders().orders(orders).build())
                .collect(Collectors.toList())
        );

    }
}
