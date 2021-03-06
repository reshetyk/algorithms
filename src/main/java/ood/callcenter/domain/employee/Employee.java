package ood.callcenter.domain.employee;

import ood.callcenter.domain.IncomeCall;
import ood.callcenter.domain.PhoneCall;

/**
 * Created by Reshetuyk on 19.02.2017.
 */
public interface Employee {
    String getName ();

    void handleCall (IncomeCall phoneCall);

    boolean canHandle (PhoneCall phoneCall);

    Integer getSupportLevel ();
}
