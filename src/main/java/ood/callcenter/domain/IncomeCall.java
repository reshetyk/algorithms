package ood.callcenter.domain;

/**
 * Created by Reshetuyk on 19.02.2017.
 */
public class IncomeCall implements PhoneCall {
    private int phone;
    private volatile int duration;

    public IncomeCall(int phone) {
        this.phone = phone;
    }

    @Override
    public int getNumber() {
        return phone;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "IncomeCall{" +
                "phone=" + phone +
                ", duration=" + duration +
                '}';
    }
}
