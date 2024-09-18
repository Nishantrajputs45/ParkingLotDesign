package services;

import exceptions.GateNotFoundException;
import models.*;
import repositories.*;
import services.factory.SpotAssignmentStrategyFactory;
import services.strategies.spotassignment.SpotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private TicketRepository ticketRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private ParkingSpotRepository parkingSpotRepository;
    private ParkingFloorRepository parkingFloorRepository;
    public  TicketService(GateRepository gateRepository,TicketRepository ticketRepository,VehicleRepository vehicleRepository,ParkingLotRepository parkingLotRepository,ParkingFloorRepository parkingFloorRepository,ParkingSpotRepository parkingSpotRepository){
        this.gateRepository=gateRepository;
        this.ticketRepository=ticketRepository;
        this.vehicleRepository=vehicleRepository;
        this.parkingLotRepository=parkingLotRepository;
        this.parkingFloorRepository=parkingFloorRepository;
        this.parkingSpotRepository=parkingSpotRepository;

    }

    public Ticket issueTicket(
            Long gateId,
            String vehicleNumber,
            VehicleType vehicleType,
            String ownerName

    ) throws GateNotFoundException {
       Ticket ticket =new Ticket();
       ticket.setEntryTime(new Date());

       //findGateById
        Optional<Gate> optionalEntryGate=gateRepository.findGateById(gateId);
        if(optionalEntryGate.isEmpty()){
           throw new  GateNotFoundException("Gate not found"+gateId);
        }
        Gate entryGate =optionalEntryGate.get();
        ticket.setEntryGate(entryGate);
        ticket.setGeneratedBy(entryGate.getOperator());

        //Get the Vehicle details if present else create a new vehicle
        Vehicle saveVehicle =vehicleRepository.findVehicleByRegistrationNumber(vehicleNumber);
        if(saveVehicle == null){
           Vehicle vehicle=new Vehicle();
            vehicle.setRegistrationNumber(vehicleNumber);
            vehicle.setOwnerName(ownerName);
            vehicle.setVehicleType(vehicleType);
            saveVehicle=vehicleRepository.save(vehicle);
        }
        ticket.setVehicle(saveVehicle);

        //Get the parking Spot
        Long parkingLotId=entryGate.getParkingLot().getId();
        ParkingLot parkingLot=parkingLotRepository.findParkingLotById(parkingLotId);

        SpotAssignmentStrategyType spotAssignmentStrategyType=parkingLot.getSpotAssignmentStrategyType();
        FeeCalculationStrategyType feeCalculationStrategyType=parkingLot.getFeeCalculationStrategyType();

        SpotAssignmentStrategy spotAssignmentStrategy= SpotAssignmentStrategyFactory.getSpotAssignmentStrategy(spotAssignmentStrategyType);

        ticket.setParkingSpot(spotAssignmentStrategy.assignSpot(vehicleType));
        ticket.setTicketNumber("AX456Z");

       return ticketRepository.save(ticket);

    }
}
