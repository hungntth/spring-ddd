package org.example.ddd.application.service.event.impl;

import org.example.ddd.application.service.event.EventAppService;
import org.springframework.stereotype.Service;

@Service
public class EventAppServiceImpl implements EventAppService {

    @Override
    public String sayHi(String who) {
        return "Hello Application ";
    }
}
