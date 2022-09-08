package system.admin.settlement.repositories.storeowners;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import system.admin.settlement.dtos.storeowners.StoreOwnerRequest;
import system.admin.settlement.entities.StoreOwners;

import static system.admin.settlement.entities.QStoreOwners.storeOwners;

@Repository
@RequiredArgsConstructor
public class StoreOwnerCustomRepositoryImpl implements StoreOwnerCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public StoreOwners getStoreOwnerByNo(Long requestId) {
        return jpaQueryFactory.selectFrom(storeOwners)
                .where(storeOwners.id.eq(requestId))
                .fetchOne();
    }

    @Override
    public Long updateStoreOwnerByNo(Long no, StoreOwnerRequest storeOwnerRequest) {
        return null;
    }

    @Override
    public Long deleteStoreOwner(Long no) {
        return null;
    }
}
