package system.admin.settlement.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import system.admin.settlement.dtos.orders.OrderResponse;
import system.admin.settlement.exceptions.FindErrorException;
import system.admin.settlement.services.OrderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/store-owner/{ownerId}/orders")
    public ResponseEntity<?> getOrderByStoreOwner(@PathVariable Long ownerId) {

        try {
            List<OrderResponse> orderResponseList = orderService.getOrdersByStoreOwnerId(ownerId)
                    .orElseThrow(() -> {
                       throw new IllegalStateException("order 조회 실패");
                    });

            return new ResponseEntity<>(orderResponseList, HttpStatus.OK);
        } catch (Exception ex) {
            throw new FindErrorException(ex);
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
