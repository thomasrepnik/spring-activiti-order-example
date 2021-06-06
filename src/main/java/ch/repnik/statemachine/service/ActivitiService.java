package ch.repnik.statemachine.service;


import ch.repnik.statemachine.controller.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricDetail;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class ActivitiService {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    @Transactional
    public String startProcess(Order order, boolean success) {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("order-sample", Collections.singletonMap("order", order));//Muss gleich heissen wie die ProcessID im Modell
        System.out.println("Process running with ProcessID: " + processInstance.getProcessInstanceId());
        return processInstance.getProcessInstanceId();
    }

    @Transactional
    public Order getProcess(String id) {
        HistoricProcessInstance processInstance = historyService.createHistoricProcessInstanceQuery().processInstanceId(id).includeProcessVariables().singleResult();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(processInstance.getProcessVariables().get("order"), Order.class);

    }

    public void getTransitions(String id) {
        List<HistoricActivityInstance> processInstance = historyService.createHistoricActivityInstanceQuery().processInstanceId(id).list();
        System.out.println(processInstance);

    }
}
