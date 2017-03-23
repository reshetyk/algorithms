package ood.parkinglot.vehicle;

import com.sun.glass.ui.Size;

/**
 * Created by Reshetuyk on 23.03.2017.
 */
public abstract class Vehicle {
    protected Size size;
    protected boolean isHandicapped;

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public boolean isHandicapped() {
        return isHandicapped;
    }

    public void setHandicapped(boolean isHandicapped) {
        this.isHandicapped = isHandicapped;
    }
}
