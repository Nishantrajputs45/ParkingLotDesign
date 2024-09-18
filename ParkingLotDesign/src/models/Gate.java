package models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Gate extends BaseModel{
    private GateType gateType;
    private  GateStatus status;
    private  ParkingLot parkingLot;
    private Operator operator;

}
