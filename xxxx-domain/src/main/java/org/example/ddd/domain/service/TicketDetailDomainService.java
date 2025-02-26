package org.example.ddd.domain.service;

import org.example.ddd.domain.model.entity.TicketDetail;

public interface TicketDetailDomainService {

    TicketDetail getTicketDetailById(Long ticketId);
}
