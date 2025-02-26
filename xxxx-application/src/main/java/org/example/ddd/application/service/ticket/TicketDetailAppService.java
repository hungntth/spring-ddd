package org.example.ddd.application.service.ticket;

import org.example.ddd.domain.model.entity.TicketDetail;

public interface TicketDetailAppService {

    TicketDetail getTicketDetailById(Long ticketId);
}
