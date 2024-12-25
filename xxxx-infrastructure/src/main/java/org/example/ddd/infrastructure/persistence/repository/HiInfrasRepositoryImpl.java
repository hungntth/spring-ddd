package org.example.ddd.infrastructure.persistence.repository;

import org.example.ddd.domain.respository.HiDomainRepository;
import org.springframework.stereotype.Service;


@Service
public class HiInfrasRepositoryImpl implements HiDomainRepository {

    @Override
    public String sayHi(String who) {
        return "Hi Infrastructure ";
    }
}
