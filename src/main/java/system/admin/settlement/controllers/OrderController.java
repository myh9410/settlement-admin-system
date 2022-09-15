package system.admin.settlement.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import system.admin.settlement.dtos.storeowners.StoreOwnerResponse;
import system.admin.settlement.services.OrderService;
import system.admin.settlement.services.StoreOwnerService;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final StoreOwnerService storeOwnerService;

    @GetMapping("/store-owner/{ownerId}/orders")
    public ResponseEntity<?> getOrderByStoreOwner(@PathVariable Long ownerId) {

        try {
            StoreOwnerResponse storeOwnerResponse = storeOwnerService.findOwnerById(ownerId);

            Long storeOwnerId = storeOwnerResponse.getId();

            System.out.println(storeOwnerId);

            orderService.getOrdersByStoreOwnerId(storeOwnerId);

            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception ex) {
            throw new RuntimeException();
        }

    }

    public ResponseEntity<?> getOrderByRegDate() {

        try {


            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception ex) {
            throw new RuntimeException();
        }

    }

}
