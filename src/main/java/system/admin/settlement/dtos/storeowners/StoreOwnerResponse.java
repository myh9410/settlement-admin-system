package system.admin.settlement.dtos.storeowners;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import system.admin.settlement.entities.StoreOwners;

@ToString
@Getter
public class StoreOwnerResponse {

    private final Long id;
    private final String name;

    @Builder
    public StoreOwnerResponse(StoreOwners storeOwners) {
        id = storeOwners.getId();
        name = storeOwners.getName();
    }

}
