package ood.callcenter.domain.employee;

import ood.callcenter.domain.IncomeCall;
import ood.callcenter.domain.PhoneCall;

import java.util.Optional;

/**
 * Created by Reshetuyk on 19.02.2017.
 */
public abstract class AbstractEmployee implements Employee {
    private String name;
    private Integer supportLevel;
    private volatile Optional<IncomeCall> currentCall = Optional.empty();

    public AbstractEmployee(String name, Integer supportLevel) {
        this.name = name;
        this.supportLevel = supportLevel;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public synchronized void handleCall(IncomeCall phoneCall) {
        try {
            this.currentCall = Optional.of(phoneCall);
            int max = 3000;
            int min = 500;
            long duration = min + (long)(Math.random() * ((max - min) + 1));
            System.out.println(Thread.currentThread() + " Employee [" + getName() + "] handling the call [" + phoneCall.getNumber() + "] duration=" + duration);
            Thread.currentThread().sleep(duration);
            phoneCall.setDuration((int)duration);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            this.currentCall = Optional.empty();
            System.out.println(Thread.currentThread() + " Employee [" + getName() + "] finished the [" + phoneCall.getNumber() + "]");
        }
    }

    @Override
    public boolean canHandle(PhoneCall phoneCall) {
        return !this.currentCall.isPresent();
    }

    @Override
    public Integer getSupportLevel() {
        return supportLevel;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", supportLevel=" + supportLevel +
                ", currentCall=" + currentCall +
                '}';
    }
}
