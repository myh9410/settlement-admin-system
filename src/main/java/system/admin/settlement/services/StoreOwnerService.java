package system.admin.settlement.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import system.admin.settlement.dtos.storeowners.StoreOwnerRequest;
import system.admin.settlement.dtos.storeowners.StoreOwnerResponse;
import system.admin.settlement.entities.StoreOwners;
import system.admin.settlement.factories.StoreOwnersFactory;
import system.admin.settlement.repositories.storeowners.StoreOwnerRepository;

import java.util.Optional;

import static org.springframework.transaction.annotation.Propagation.*;

@Service
@RequiredArgsConstructor
public class StoreOwnerService {

    private final StoreOwnerRepository storeOwnerRepository;
    private final StoreOwnersFactory storeOwnersFactory;

    public StoreOwnerResponse findOwnerById(Long ownerId) {

        StoreOwners storeOwners = storeOwnerRepository.getStoreOwnerByNo(ownerId);

        return StoreOwnerResponse.builder()
                .storeOwners(storeOwners)
                .build();

    }

    @Transactional(propagation = REQUIRES_NEW)
    public StoreOwnerResponse createStoreOwner(StoreOwnerRequest storeOwnerRequest) {

        // to entity
        StoreOwners storeOwners = storeOwnersFactory.generateStoreOwnersBy(
                storeOwnerRequest
        );

        storeOwnerRepository.save(storeOwners);

        return StoreOwnerResponse.builder()
                .storeOwners(storeOwners)
                .build();

    }

    @Transactional
    public void deleteStoreOwner(Long ownerId) {

        storeOwnerRepository.deleteStoreOwner(ownerId);

    }
}
