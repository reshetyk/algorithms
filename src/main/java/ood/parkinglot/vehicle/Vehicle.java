package ood.parkinglot.vehicle;

import ood.parkinglot.Size;

/**
 * Created by Reshetuyk on 23.03.2017.
 */
public abstract class Vehicle {
    protected Size size;
    protected boolean isHandicapped;

    protected Vehicle(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public boolean isHandicapped() {
        return isHandicapped;
    }

    public void setHandicapped(boolean isHandicapped) {
        this.isHandicapped = isHandicapped;
    }
}
