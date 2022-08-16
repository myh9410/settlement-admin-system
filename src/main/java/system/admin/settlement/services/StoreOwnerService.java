package system.admin.settlement.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import system.admin.settlement.dtos.storeowners.StoreOwnerResponse;
import system.admin.settlement.entities.StoreOwners;
import system.admin.settlement.repositories.storeowners.StoreOwnerRepository;

@Service
@RequiredArgsConstructor
public class StoreOwnerService {

    private final StoreOwnerRepository storeOwnerRepository;

    public StoreOwnerResponse findOwnerById(Long ownerId) {

        StoreOwners storeOwners = storeOwnerRepository.getStoreOwnerByNo(ownerId);

        return StoreOwnerResponse.builder()
                .storeOwners(storeOwners)
                .build();

    }

}
