package ood.parkinglot;

import java.util.Date;

/**
 * Created by Reshetuyk on 24.03.2017.
 */
public class Ticket {
    private Date arrivalDate;
    private Integer parkingSpaceNo;

    public Ticket(Date arrivalDate, Integer parkingSpaceNo) {
        this.arrivalDate = arrivalDate;
        this.parkingSpaceNo = parkingSpaceNo;
    }

    public Integer getParkingSpaceNo() {
        return parkingSpaceNo;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }
}
