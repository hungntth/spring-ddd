package org.example.ddd.application.service.event.impl;

import jakarta.annotation.Resource;
import org.example.ddd.application.service.event.EventAppService;
import org.example.ddd.domain.service.HiDomainService;
import org.springframework.stereotype.Service;

@Service
public class EventAppServiceImpl implements EventAppService {

    @Resource
    private HiDomainService hiDomainService;

    @Override
    public String sayHi(String who) {
        return hiDomainService.sayHi(who);
    }
}
