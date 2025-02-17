package org.example.Controller;

import org.example.Model.RequestDTO;
import org.example.Model.ResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Random;

@RestController
public class Controller {
    @PostMapping(value="/balance",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Object balance(@RequestBody RequestDTO req) {
        try {
            char firstDigit = req.getClientId().charAt(0);
            int maxLim;
            String uid = req.getRqUID();
            String currency;

            if (firstDigit == '8') {
                maxLim = 2000;
                currency="US";

            } else if (firstDigit == '9') {
                maxLim = 1000;
                currency="EU";
            } else {
                maxLim = 10000;
                currency="RU";
            }

            Random random = new Random();


            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setRqUID(uid);
            responseDTO.setClientId(req.getClientId());
            responseDTO.setAccount(req.getAccount());
            responseDTO.setCurrency(currency);
            responseDTO.setBalance(String.valueOf(random.nextInt(maxLim+1)) + ".00");
            responseDTO.setMaxLimit(String.valueOf(maxLim) + ".00");

            return responseDTO;

        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }

    }
}
