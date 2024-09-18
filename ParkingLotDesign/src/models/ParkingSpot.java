package models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ParkingSpot extends BaseModel{
    private String spotNumber; //e.g A1, B5, G7 etc
    private ParkingSpotStatus status;
    private List<VehicleType> supportedVehicleTypes;
    private Long parkingFloorId;



}
