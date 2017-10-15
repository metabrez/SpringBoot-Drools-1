package com.mouni.controller;

import com.mouni.Service.DroolsService;
import com.mouni.model.CreditDetails;
import lombok.extern.slf4j.Slf4j;
import org.drools.compiler.compiler.DroolsParserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
public class DroolsController {

    @Autowired
    DroolsService droolsService;

    @RequestMapping("/approvalStatus")
    public CreditDetails getResult(@RequestParam(value="score") int score) {

        CreditDetails message = null;
        try {
            message = droolsService.getMessage(score);
        } catch (DroolsParserException ex) {
            log.error("Error with DroolsParserException : {}", ex);
        } catch (IOException exc) {
            log.error("Error with IOEXCEPTION : {}", exc);
        }
        return message;
    }
}
