package system.admin.settlement.factories;

import org.springframework.stereotype.Component;
import system.admin.settlement.dtos.storeowners.StoreOwnerRequest;
import system.admin.settlement.entities.StoreOwners;

@Component
public class StoreOwnersFactory {
    public static StoreOwners generateStoreOwnersBy(StoreOwnerRequest storeOwnerRequest) {
        StoreOwners storeOwners = StoreOwners.builder()
                .name(storeOwnerRequest.getName())
                .build();

        return storeOwners;
    }
}
