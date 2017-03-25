package ood.parkinglot;

import ood.parkinglot.vehicle.Vehicle;
import org.apache.commons.lang3.Validate;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

/**
 * Created by Reshetuyk on 23.03.2017.
 */
public class ParkingLot {
    private List<Space> spaces = new ArrayList<>();

    private ParkingLot() { /* only via builder */ }

    public List<Space> getFreeSpaces() {
        return unmodifiableList(spaces.stream().filter(s -> s.isFree()).collect(Collectors.toList()));
    }

    public Optional<Space> getAnyFreeSpaceWithType(SpaceType spaceType) {
        return getFreeSpaces().stream().filter(s -> s.getType() == spaceType).findAny();
    }

    public Optional<Space> getAnyFreeSpaceWithMostSuitableSize(Vehicle vehicle, SpaceType ... excludeTypes) {
        Comparator<Space> bySpaceSize = (o1, o2) -> o1.getType().getSize().compareTo(o2.getType().getSize());

        return getFreeSpaces().stream().sorted(bySpaceSize)
                .filter(s -> !asList(excludeTypes).contains(s.getType()))
                .filter(s -> s.isFitForSize(vehicle)).findAny();
    }


    public Space getSpaceByNo(Integer parkingSpaceNo) {
        return spaces.stream()
                .filter(s -> s.getNumber().equals(parkingSpaceNo))
                .findAny().orElseThrow(() ->
                                new RuntimeException("not found  parking place with no [" + parkingSpaceNo + "]")
                );
    }

    void addSpace(Space space) {
        spaces.add(space);
    }


    static class Builder {
        private ParkingLot parkingLot = new ParkingLot();
        private SpacesBuilder spacesBuilder = new SpacesBuilder();
        private Integer countSpaces;

        public SpacesBuilder withSpacesCount(int countSpaces) {
            this.countSpaces = countSpaces;
            return spacesBuilder;
        }

        class SpacesBuilder {
            private TypeBuilder typeBuilder = new TypeBuilder();

            public TypeBuilder buildSpaces() {
                return typeBuilder;
            }

            public ParkingLot build() {
                int actualSpacesCount = typeBuilder.spaceTypeByCountMap.values().stream().mapToInt(s -> s.intValue()).sum();

                Validate.isTrue(actualSpacesCount <= countSpaces,
                        "Cannot build parking lot with [%d] places because the limit is [%d]",
                        actualSpacesCount, countSpaces);

                int no = 0;
                for (Map.Entry<SpaceType, Integer> entry : typeBuilder.spaceTypeByCountMap.entrySet()) {
                    for (int i = 0; i < entry.getValue(); i++) {
                        parkingLot.addSpace(new Space(++no, entry.getKey()));
                    }
                }

                return parkingLot;
            }


            class TypeBuilder {
                private SpaceType spaceType;
                private Map<SpaceType, Integer> spaceTypeByCountMap = new HashMap<>();
                private CountTypeBuilder countTypeBuilder = new CountTypeBuilder();

                public CountTypeBuilder withType(SpaceType spaceType) {
                    this.spaceType = spaceType;
                    return countTypeBuilder;
                }

                class CountTypeBuilder {
                    public SpacesBuilder withCount(int count) {
                        Validate.isTrue(count > 0, "Count should be greater then %d", count);
                        spaceTypeByCountMap.put(spaceType, count);
                        return SpacesBuilder.this;
                    }
                }
            }
        }
    }
}
