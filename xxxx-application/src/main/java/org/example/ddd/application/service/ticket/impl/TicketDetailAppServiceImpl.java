package org.example.ddd.application.service.ticket.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.ddd.application.service.ticket.TicketDetailAppService;
import org.example.ddd.application.service.ticket.cache.TicketDetailCacheService;
import org.example.ddd.domain.model.entity.TicketDetail;
import org.example.ddd.domain.service.TicketDetailDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TicketDetailAppServiceImpl implements TicketDetailAppService {
    // CALL Service Domain Module
    private TicketDetailDomainService ticketDetailDomainService;

    // CALL CACHE
    @Autowired
    private TicketDetailCacheService ticketDetailCacheService;

    @Override
    public TicketDetail getTicketDetailById(Long ticketId) {
        return ticketDetailCacheService.getTicketDefaultCacheVip(ticketId, System.currentTimeMillis());
    }
}
