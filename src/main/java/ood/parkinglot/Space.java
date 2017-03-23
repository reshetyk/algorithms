package ood.parkinglot;


import ood.parkinglot.vehicle.Vehicle;

import java.util.Optional;

/**
 * Created by Reshetuyk on 23.03.2017.
 */
public class Space {

    private Integer number;
    private SpaceType type;
    private Optional<Vehicle> vehicle = Optional.empty();

    public Space(SpaceType type) {
        this.type = type;
    }

    public boolean withinSize(Vehicle vehicle) {
        return type.withinInSize(vehicle.getSize());
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

    public Vehicle getVehicle() {
        return vehicle.get();
    }

    public Vehicle release() {
        Vehicle result = vehicle.get();
        this.vehicle = Optional.empty();
        return result;
    }

    public void occupy(Vehicle vehicle) {
        this.vehicle = Optional.of(vehicle);
    }

    public boolean isFree() {
        return this.vehicle.isPresent();
    }
}
