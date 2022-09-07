package system.admin.settlement.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import system.admin.settlement.dtos.storeowners.StoreOwnerRequest;
import system.admin.settlement.dtos.storeowners.StoreOwnerResponse;
import system.admin.settlement.exceptions.FindErrorException;
import system.admin.settlement.exceptions.SaveErrorException;
import system.admin.settlement.services.StoreOwnerService;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class StoreOwnerController {

    private final StoreOwnerService storeOwnerService;

    @GetMapping("/store-owner/{ownerId}")
    public ResponseEntity<StoreOwnerResponse> getStoreOwner(@PathVariable Long ownerId) {

        if (Objects.isNull(ownerId)) throw new NullPointerException("owner_id is null");

        try {
            StoreOwnerResponse storeOwnerResponse = storeOwnerService.findOwnerById(ownerId);

            return new ResponseEntity<>(storeOwnerResponse, HttpStatus.OK);
        } catch (Exception ex) {
            throw new FindErrorException(ex);
        }

    }

    @PostMapping("/store-owner")
    public ResponseEntity<StoreOwnerResponse> saveStoreOwner(@RequestBody @Valid StoreOwnerRequest storeOwnerRequest) {

        try {
            StoreOwnerResponse storeOwnerResponse = storeOwnerService.createStoreOwner(storeOwnerRequest);

            return new ResponseEntity<>(storeOwnerResponse, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            throw new SaveErrorException(HttpMethod.POST, ex);
        }

    }

    @DeleteMapping("/store-owner/{ownerId}")
    public void deleteStoreOwner(@PathVariable Long ownerId) {
        storeOwnerService.deleteStoreOwner(ownerId);
    }

}
