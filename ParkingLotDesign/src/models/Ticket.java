package models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Ticket extends BaseModel{
    private String ticketNumber; //Random String of 7 characters
    private Date entryTime;
    private ParkingSpot parkingSpot;
    private Vehicle vehicle;
    private Gate entryGate;
    private Operator generatedBy;


}
