package ood.callcenter.service;

import ood.callcenter.domain.CallCenterTeam;
import ood.callcenter.domain.HistoryCalls;
import ood.callcenter.domain.IncomeCall;
import ood.callcenter.domain.employee.Employee;

import java.util.Optional;
import java.util.concurrent.ExecutorService;

/**
 * Created by Reshetuyk on 19.02.2017.
 */
public class CallCenterService {
    private ExecutorService threadPoolExecutor;
    private CallCenterTeam team;
    private HistoryCalls history = new HistoryCalls();

    public CallCenterService(CallCenterTeam team, ExecutorService executorService) {
        this.team = team;
        this.threadPoolExecutor = executorService;
    }

    public void handleCall(IncomeCall phoneCall) {
        Optional<Employee> freeEmployee = team.stream()
                .filter(e -> e.canHandle(phoneCall))
                .sorted((e1, e2) -> e1.getSupportLevel().compareTo(e2.getSupportLevel()))
                .findFirst();

        if (freeEmployee.isPresent()) {
            threadPoolExecutor.submit(() -> freeEmployee.get().handleCall(phoneCall));
            history.add(freeEmployee.get(), phoneCall);
        }
        else
            System.out.println(phoneCall.toString() + " cannot be handled all operators are busy");
    }

    public HistoryCalls getHistoryCalls() {
        return history;
    }
}
