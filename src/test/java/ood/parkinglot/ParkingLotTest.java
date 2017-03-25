package ood.parkinglot;

import ood.parkinglot.vehicle.Bus;
import ood.parkinglot.vehicle.Vehicle;
import org.junit.Test;

import java.util.Optional;

import static ood.parkinglot.SpaceType.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ParkingLotTest {

    @Test
    public void testParkingLotBuilderValidation() {

        ParkingLot.Builder.SpacesBuilder parkingLotBuilder = new ParkingLot.Builder()
                .withSpacesCount(10)
                .buildSpaces().withType(COMPACT).withCount(5)
                .buildSpaces().withType(LARGE).withCount(5)
                .buildSpaces().withType(HANDICAPPED).withCount(1);

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> parkingLotBuilder.build())
                .withMessageContaining("Cannot build parking lot with [11] places because the limit is [10]");
    }

    @Test
    public void testParkAndUnParkBus() throws Exception {
        ParkingLot parkingLot = new ParkingLot.Builder()
                .withSpacesCount(10)
                .buildSpaces().withType(COMPACT).withCount(5)
                .buildSpaces().withType(LARGE).withCount(3)
                .buildSpaces().withType(HANDICAPPED).withCount(2)
                .build();

        Parker parker = new Parker(parkingLot);

        Bus bus = new Bus(new Size(LARGE.getSize().getWidth() - 30, LARGE.getSize().getHeight() - 30));

        Optional<Ticket> ticket = parker.park(bus);

        assertThat(ticket).isPresent();
        assertThat(ticket.get().getArrivalDate()).isNotNull();
        assertThat(ticket.get().getParkingSpaceNo()).isGreaterThan(0);

        Space space = parkingLot.getSpaceByNo(ticket.get().getParkingSpaceNo());
        assertThat(space.getType()).isEqualTo(LARGE);

        Vehicle vehicle = parker.unPark(ticket.get());
        assertThat(vehicle).isExactlyInstanceOf(Bus.class).isEqualTo(bus);

        assertThat(space.getVehicle().isPresent()).isFalse();
        assertThat(space.isFree()).isTrue();
    }

}