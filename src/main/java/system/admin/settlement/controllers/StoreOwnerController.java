package system.admin.settlement.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import system.admin.settlement.dtos.storeowners.StoreOwnerResponse;
import system.admin.settlement.services.StoreOwnerService;

@RestController
@RequiredArgsConstructor
public class StoreOwnerController {

    private final StoreOwnerService storeOwnerService;

    @GetMapping("/store-owner/{ownerId}")
    public StoreOwnerResponse getStoreOwner(@PathVariable Long ownerId) {

        return storeOwnerService.findOwnerById(ownerId);

    }

}
