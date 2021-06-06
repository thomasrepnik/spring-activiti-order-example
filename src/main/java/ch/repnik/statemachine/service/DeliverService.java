package ch.repnik.statemachine.service;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service
public class DeliverService implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        System.out.println("Delivering...");
    }
}
