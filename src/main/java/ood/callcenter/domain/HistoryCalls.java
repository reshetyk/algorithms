package ood.callcenter.domain;

import ood.callcenter.domain.employee.Employee;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Reshetuyk on 20.02.2017.
 */
public class HistoryCalls {
    private Map<Employee, List<PhoneCall>> history = Collections.synchronizedMap(new LinkedHashMap<>());

    public void add(Employee employee, PhoneCall call) {
        history.computeIfPresent(employee, (employee1, phoneCalls) -> {
            phoneCalls.add(call);
            return phoneCalls;
        });
        history.computeIfAbsent(employee, employee1 -> {
            List<PhoneCall> phoneCalls = new CopyOnWriteArrayList<>();
            phoneCalls.add(call);
            return phoneCalls;
        });
    }

    public List<PhoneCall> getPhoneCallsBy(Employee employee) {
        return history.get(employee);
    }

    public Set<Employee> allEmployees() {
        return history.keySet();
    }

    public List<PhoneCall> phoneCalls () {
        ArrayList<PhoneCall> phoneCalls = new ArrayList<>();
        history.values().forEach(col -> phoneCalls.addAll(col));
        return phoneCalls;
    }

}
