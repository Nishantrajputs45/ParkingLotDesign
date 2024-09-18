import controllers.TicketController;
import dtos.IssueTicketRequestDto;
import dtos.IssueTicketResponseDto;
import models.VehicleType;
import repositories.*;
import services.TicketService;

public class Client {
    private static GateRepository gateRepository=new GateRepository();
    private static TicketRepository ticketRepository=new TicketRepository();
    private static VehicleRepository vehicleRepository=new VehicleRepository();
    private static ParkingLotRepository parkingLotRepository=new ParkingLotRepository();
    private static ParkingSpotRepository parkingSpotRepository=new ParkingSpotRepository();
    private static ParkingFloorRepository parkingFloorRepository=new ParkingFloorRepository();

    private static TicketService ticketService =new TicketService(gateRepository,ticketRepository,vehicleRepository,parkingLotRepository, parkingFloorRepository,parkingSpotRepository);


    public static void main(String[] args) {
        demoIssueTicket();
    }

    private static void demoIssueTicket() {
        IssueTicketRequestDto issueTicketRequestDto=new IssueTicketRequestDto();
        issueTicketRequestDto.setGateId(1L);
        issueTicketRequestDto.setOwnerName("Akshay");
        issueTicketRequestDto.setRegistrationNumber("MH12AB1234");
        issueTicketRequestDto.setVehicleType(VehicleType.FOUR_WHEELER);

        TicketController ticketController=new TicketController(ticketService);
        IssueTicketResponseDto issueTicketResponseDto=ticketController.issueTicket(issueTicketRequestDto);
        System.out.println(issueTicketResponseDto.getTicket());

    }
}
