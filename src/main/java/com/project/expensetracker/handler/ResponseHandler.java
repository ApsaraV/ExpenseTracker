package com.project.expensetracker.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

   public static ResponseEntity<Object> generateResponse(Object responseObject, String message, HttpStatus httpStatus) {
      Map<String, Object> responseObjectMap = new HashMap<>();
      responseObjectMap.put("data", responseObject);
      responseObjectMap.put("status", httpStatus);
      responseObjectMap.put("message", message);
      return new ResponseEntity<>(responseObjectMap, httpStatus);
   }

}
