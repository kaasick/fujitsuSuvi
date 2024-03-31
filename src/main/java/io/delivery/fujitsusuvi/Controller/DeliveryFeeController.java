package io.delivery.fujitsusuvi.Controller;

import io.delivery.fujitsusuvi.service.DeliveryFeeService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping ("/delivery-fee")
public class DeliveryFeeController {

    //Controller using the DeliveryFeeService to calculate the delivery fee
    //@GetMapping for the http get request onto the calculation method, accepting city and vehicleType

    private final DeliveryFeeService deliveryFeeService;

    @Autowired
    public DeliveryFeeController(DeliveryFeeService deliveryFeeService) {

        //private static final Logger log = LoggerFactory.getLogger(DeliveryFeeController.class);

        this.deliveryFeeService = deliveryFeeService;
    }

    @GetMapping("/{city}/{vehicleType}")
    public ResponseEntity<?> calculateDeliveryFee(@PathVariable String city, @PathVariable String vehicleType) {
        try {
            double fee = deliveryFeeService.calculateFee(city, vehicleType);
            return ResponseEntity.ok(fee);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
