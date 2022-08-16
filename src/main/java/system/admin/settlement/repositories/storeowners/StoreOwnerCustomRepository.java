package system.admin.settlement.repositories.storeowners;

import system.admin.settlement.dtos.storeowners.StoreOwnerRequest;
import system.admin.settlement.entities.StoreOwners;

public interface StoreOwnerCustomRepository {

    public StoreOwners getStoreOwnerByNo(Long no);

    public Long updateStoreOwnerByNo(Long no, StoreOwnerRequest storeOwnerRequest);

    public Long deleteStoreOwner(Long no);

}
