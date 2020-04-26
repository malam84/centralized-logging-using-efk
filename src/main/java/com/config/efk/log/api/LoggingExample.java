package com.config.efk.log.api;

import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class LoggingExample {

	private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    @RequestMapping(value = "/api/efk/{msg}", method = RequestMethod.GET)
    public ResponseEntity<String> queryByCPF(@PathVariable String msg) {
        try {
            logger.info("Log message is :  " + msg);
            return new ResponseEntity<String>(msg, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
