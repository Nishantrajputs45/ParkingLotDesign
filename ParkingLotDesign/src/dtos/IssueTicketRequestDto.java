package dtos;

import lombok.Getter;
import lombok.Setter;
import models.VehicleType;

@Setter
@Getter
public class IssueTicketRequestDto {
    private Long gateId;
    private VehicleType vehicleType;
    private String registrationNumber;
    private String ownerName;


}
