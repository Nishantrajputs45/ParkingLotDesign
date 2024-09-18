package models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Vehicle extends BaseModel{
    private String registrationNumber;
    private String ownerName;
    private VehicleType vehicleType;
}
