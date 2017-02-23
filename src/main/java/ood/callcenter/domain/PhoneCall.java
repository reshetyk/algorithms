package ood.callcenter.domain;

/**
 * Created by Reshetuyk on 19.02.2017.
 */
public interface PhoneCall {
    int getNumber ();
    int getDuration();
    boolean isInProgress();
}
