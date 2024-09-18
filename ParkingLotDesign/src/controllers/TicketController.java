package controllers;

import dtos.IssueTicketRequestDto;
import dtos.IssueTicketResponseDto;
import dtos.ResponseStatus;
import exceptions.GateNotFoundException;
import models.Ticket;
import services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService=ticketService;
    }

    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto issueTicketRequestDto)  {
         IssueTicketResponseDto issueTicketResponseDto=new IssueTicketResponseDto();
         try{
             Ticket ticket=ticketService.issueTicket(
                     issueTicketRequestDto.getGateId(),
                     issueTicketRequestDto.getRegistrationNumber(),
                     issueTicketRequestDto.getVehicleType(),
                     issueTicketRequestDto.getOwnerName());
         }
         catch(GateNotFoundException gateNotFoundException){
             System.out.println(gateNotFoundException.getMessage());
             issueTicketResponseDto.setResponseStatus(ResponseStatus.FAILURE);

        }
         return issueTicketResponseDto;
    }
}
