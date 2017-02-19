package ood.callcenter.domain.employee;

import ood.callcenter.domain.PhoneCall;

import java.util.Optional;

/**
 * Created by Reshetuyk on 19.02.2017.
 */
public abstract class AbstractEmployee implements Employee {
    private String name;
    private Integer supportLevel;
    private Optional<PhoneCall> currentCall = Optional.empty();

    public AbstractEmployee(String name, Integer supportLevel) {
        this.name = name;
        this.supportLevel = supportLevel;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public synchronized void handleCall(PhoneCall phoneCall) {
        try {
            this.currentCall = Optional.of(phoneCall);
            int max = 3000;
            int min = 1000;
            long millis = min + (long)(Math.random() * ((max - min) + 1));
            System.out.println(Thread.currentThread() + " Employee [" + getName() + "] handling the call " + phoneCall.toString() + "millis=" + millis);
            Thread.currentThread().sleep(millis);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            this.currentCall = Optional.empty();
            System.out.println(Thread.currentThread() + " Employee [" + getName() + "] finished the " + phoneCall.toString());
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
