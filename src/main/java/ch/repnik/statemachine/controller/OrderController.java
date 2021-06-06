package ch.repnik.statemachine.controller;

import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    
    @Autowired
    private RuntimeService runtimeService;


    @GetMapping (path = "/order/success")
    public ResponseEntity<String> createSuccessfulOrder(){
    
        runtimeService.startProcessInstanceByKey("order-sample"); //Muss gleich heissen wie die ProcessID im Modell
        
        return ResponseEntity.ok("Process started. Number of currently running"
            + "process instances = "
            + runtimeService.createProcessInstanceQuery().count());
    }

    




}
