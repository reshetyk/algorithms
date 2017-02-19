package ood.callcenter.service;

import ood.callcenter.domain.CallCenterTeam;
import ood.callcenter.domain.PhoneCall;
import ood.callcenter.domain.employee.Employee;

import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Reshetuyk on 19.02.2017.
 */
public class CallCenterService {
    private ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(10);
    private CallCenterTeam team;

    public CallCenterService(CallCenterTeam team) {
        this.team = team;
    }

    public void handleCall(PhoneCall phoneCall) {
        Optional<Employee> freeEmployee = team.stream()
                .filter(e -> e.canHandle(phoneCall))
                .sorted((e1, e2) -> e1.getSupportLevel().compareTo(e2.getSupportLevel()))
                .findFirst();

        if (freeEmployee.isPresent())
            threadPoolExecutor.submit(() -> freeEmployee.get().handleCall(phoneCall));
        else
            System.out.println(phoneCall.toString() + " cannot be handled all operators are busy");
    }
}
