package system.admin.settlement.repositories.storeowners;

import org.springframework.data.jpa.repository.JpaRepository;
import system.admin.settlement.entities.StoreOwners;

public interface StoreOwnerRepository extends JpaRepository<StoreOwners, Long>, StoreOwnerCustomRepository {}
