package dtos;

import lombok.Getter;
import lombok.Setter;
import models.Ticket;

@Setter
@Getter
public class IssueTicketResponseDto {
    private Ticket ticket;
    private ResponseStatus responseStatus;
}
