package system.admin.settlement.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import system.admin.settlement.services.OrderService;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    public ResponseEntity<?> getOrderByStoreOwner() {

        try {


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
