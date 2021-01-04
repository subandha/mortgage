package net.apicraft.mortgage.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import net.apicraft.mortgage.bl.Amortizer;
import net.apicraft.mortgage.model.AmortizationSchedule;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import javax.validation.constraints.PositiveOrZero;

@RestController
@Validated
public class AmortizerController {
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/schedule")
    public ResponseEntity<AmortizationSchedule> getSchedule(@RequestParam(value="principal") @PositiveOrZero double principal,
                                                            @RequestParam(value="apr") @PositiveOrZero double apr,
                                                            @RequestParam(value = "period") @Min(1) int period) {
        Amortizer amortizer = new Amortizer(principal,apr,period,Amortizer.Frequency.MONTHLY);
        return ResponseEntity.ok(amortizer.amortize());

    }

}
