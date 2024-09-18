package repositories;

import models.ParkingSpot;

import java.util.Map;
import java.util.TreeMap;

public class ParkingSpotRepository {
    private Map<Long, ParkingSpot> parkingSpotMap=new TreeMap<>();
    private Long previousId=0L;

    public ParkingSpot save(ParkingSpot parkingSpot){
        if(parkingSpot.getId()==null){
            parkingSpot.setId(++previousId);
        }
        parkingSpotMap.put(parkingSpot.getId(),parkingSpot);
        return parkingSpot;
    }

    public ParkingSpot findParkingSpotById(Long id){
        return parkingSpotMap.get(id);
    }
}
