package ch.repnik.statemachine.controller;

import ch.repnik.statemachine.service.ActivitiService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.persistence.entity.ExecutionEntityImpl;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Event;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class OrderController {
    
    @Autowired
    private ActivitiService activitiService;


    @PostMapping (path = "/order/success")
    public ResponseEntity<String> createSuccessfulOrder(@RequestBody Order order){
        String processId = activitiService.startProcess(order, true);
        return ResponseEntity.ok(processId);
    }

    @GetMapping (path = "/order/{id}")
    public ResponseEntity<Order> createSuccessfulOrder(@PathVariable String id){

        Order order = activitiService.getProcess(id);


        return ResponseEntity.ok(order);


    }

    @GetMapping (path = "/order/transitions/{id}")
    public ResponseEntity<String> createSuccessfulOrderw(@PathVariable String id){

        activitiService.getTransitions(id);


        return ResponseEntity.ok("order");


    }

    




}
