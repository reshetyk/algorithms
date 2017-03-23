package ood.parkinglot;

import ood.parkinglot.vehicle.Vehicle;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static ood.parkinglot.SpaceType.HANDICAPPED;

/**
 * Created by Reshetuyk on 23.03.2017.
 */
public class ParkingLot {
    private List<Space> spaces;

    public ParkingLot(List<Space> spaces) {
        this.spaces = spaces;
    }

    public Optional<Ticket> park(Vehicle vehicle) {
        if (spaces.stream().noneMatch(s -> s.isFree() || s.withinSize(vehicle)))
            return empty();

        if (vehicle.isHandicapped()) {
            Optional<Space> spaceOpt = spaces.stream().filter(s -> s.getType() == HANDICAPPED && s.isFree()).findAny();
            Space space = spaceOpt.isPresent() ? spaceOpt.get() : findMostSizeSuitable(vehicle);
            space.occupy(vehicle);
            return of(new Ticket(new Date(), space.getNumber()));
        }

        throw new NotImplementedException();
    }

    public Vehicle release(Ticket ticket) {
        Space space = spaces.stream().filter(s -> s.getNumber().equals(ticket.getParkingSpaceNo()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("not found vehicle"));

        return space.release();
    }

    private Space findMostSizeSuitable(Vehicle vehicle) {
        throw new NotImplementedException();
    }
}
