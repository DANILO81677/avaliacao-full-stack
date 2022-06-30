package br.com.tokiomarine.evaluationbackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping
public class HealhCheckController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity<String> getCustomer() {
    	log.info("executing healthcheck");
        return new ResponseEntity<String>("OK", HttpStatus.OK);
        
    }

}
