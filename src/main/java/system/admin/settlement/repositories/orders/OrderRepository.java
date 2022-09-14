package system.admin.settlement.repositories.orders;

import org.springframework.data.jpa.repository.JpaRepository;
import system.admin.settlement.entities.Orders;

public interface OrderRepository extends OrderCustomRepository, JpaRepository<Orders, Long> {
}
