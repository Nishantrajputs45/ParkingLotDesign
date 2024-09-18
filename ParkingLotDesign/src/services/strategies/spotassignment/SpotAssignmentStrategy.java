package services.strategies.spotassignment;

import models.ParkingSpot;
import models.VehicleType;

public interface SpotAssignmentStrategy {
    ParkingSpot assignSpot(VehicleType vehicleType);
}
