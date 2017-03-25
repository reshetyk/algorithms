package ood.parkinglot;


import ood.parkinglot.vehicle.Vehicle;
import org.apache.commons.lang3.Validate;

import java.util.Optional;

/**
 * Created by Reshetuyk on 23.03.2017.
 */
public class Space {

    private Integer number;
    private SpaceType type;
    private Optional<Vehicle> vehicle = Optional.empty();

    public Space(Integer number, SpaceType type) {
        this.number = number;
        this.type = type;
    }

    public boolean isFitForSize(Vehicle vehicle) {
        int capacity = 20;
        return type.withinInSize(new Size(
                        vehicle.getSize().getWidth() + capacity,
                        vehicle.getSize().getHeight() + capacity)
        );
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public SpaceType getType() {
        return type;
    }

    public Optional<Vehicle> getVehicle() {
        return vehicle;
    }

    public Vehicle release() {
        if (isFree())
            throw new RuntimeException("Cannot release space [" + toString() + "] because it is already free");

        Vehicle result = vehicle.get();
        this.vehicle = Optional.empty();
        return result;
    }

    public void occupyWith(Vehicle vehicle) {
        Validate.isTrue(isFitForSize(vehicle), "The vehicle is not fit for size for the space [" + toString() + "]");
        this.vehicle = Optional.of(vehicle);
    }

    public boolean isFree() {
        return !this.vehicle.isPresent();
    }

    @Override
    public String toString() {
        return "Space{" +
                "number=" + number +
                ", type=" + type +
                '}';
    }
}
