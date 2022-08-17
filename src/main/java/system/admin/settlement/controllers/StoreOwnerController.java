package system.admin.settlement.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import system.admin.settlement.dtos.storeowners.StoreOwnerRequest;
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

    @PostMapping("/store-owner")
    public StoreOwnerResponse saveStoreOwner(@RequestBody StoreOwnerRequest storeOwnerRequest) {

        return storeOwnerService.createStoreOwner(storeOwnerRequest);

    }

}
