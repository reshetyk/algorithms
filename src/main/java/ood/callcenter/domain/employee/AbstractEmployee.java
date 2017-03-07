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

    public synchronized void handleCall(IncomeCall phoneCall) {
        try {
            this.currentCall = Optional.of(phoneCall);
            System.out.println(Thread.currentThread() + " Employee [" + getName() + "] handling the call [" + phoneCall.getNumber() + "]");
            phoneCall.setInProgress(true);
            phoneCall.setDuration((int) waitUntilCallInProgressAndGetDuration());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            this.currentCall = Optional.empty();
            System.out.println(Thread.currentThread() + " Employee [" + getName() + "] finished the [" + phoneCall + "]");
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

    public AbstractEmployee setSupportLevel(int supportLevel) {
        this.supportLevel = supportLevel;
        return this;
    }

    @Override
    public String getName() {
        return name;
    }

    public AbstractEmployee setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", supportLevel=" + supportLevel +
                ", currentCall=" + currentCall +
                '}';
    }

    private long waitUntilCallInProgressAndGetDuration() {
        long startTime = System.currentTimeMillis();
        while (currentCall.get().isInProgress()) {/* talk */}
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
