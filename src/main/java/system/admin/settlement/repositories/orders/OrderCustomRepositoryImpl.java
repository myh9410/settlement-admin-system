package system.admin.settlement.repositories.orders;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import system.admin.settlement.entities.Orders;

import java.time.LocalDateTime;
import java.util.List;

import static system.admin.settlement.entities.QOrders.orders;

@Repository
@RequiredArgsConstructor
public class OrderCustomRepositoryImpl implements OrderCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Orders> findOrdersByStoreOwnerId(Long storeOwnerId) {
        return jpaQueryFactory.selectFrom(orders)
                .where(orders.storeOwners.id.eq(storeOwnerId))
                .fetch();
    }

    @Override
    public List<Orders> findOrdersByRegDate(LocalDateTime regDateTime) {
        return jpaQueryFactory.selectFrom(orders)
                .where(orders.createdDate.after(regDateTime))
                .fetch();
    }
}
