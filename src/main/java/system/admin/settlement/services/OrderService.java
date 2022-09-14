package system.admin.settlement.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import system.admin.settlement.repositories.orders.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

}
