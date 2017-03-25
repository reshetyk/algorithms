package ood.parkinglot;

import ood.parkinglot.vehicle.Vehicle;

import java.util.Date;
import java.util.Optional;

/**
 * Created by Reshetuyk on 25.03.2017.
 */
public class Parker {

    private ParkingLot parkingLot;

    public Parker(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Optional<Ticket> park(Vehicle vehicle) {
        Optional<Space> space = Optional.empty();

        if (vehicle.isHandicapped()) {
            space = parkingLot.getAnyFreeSpaceWithType(SpaceType.HANDICAPPED);
        }

        space = space.isPresent() ? space : parkingLot.getAnyFreeSpaceWithMostSuitableSize(vehicle, SpaceType.HANDICAPPED);

        if (!space.isPresent()) return Optional.empty();

        space.get().occupyWith(vehicle);

        return Optional.of(new Ticket(new Date(), space.get().getNumber()));
    }

    public Vehicle unPark(Ticket ticket) {
        return parkingLot.getSpaceByNo(ticket.getParkingSpaceNo()).release();
    }
}

