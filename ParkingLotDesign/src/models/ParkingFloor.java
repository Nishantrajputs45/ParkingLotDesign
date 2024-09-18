package models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ParkingFloor extends BaseModel{
    private int floorNumber;
    private ParkingFloorStatus status;
    private List<ParkingSpot> parkingSpots;

}
