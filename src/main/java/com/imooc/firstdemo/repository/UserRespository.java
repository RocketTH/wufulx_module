package com.imooc.firstdemo.repository;


import com.imooc.firstdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserRespository {

    private ConcurrentMap<Integer, User> repository = new ConcurrentHashMap<>();

    private final static AtomicInteger idGenerator =
                new AtomicInteger();

    public boolean save(User user) {
        Integer id = idGenerator.incrementAndGet();
        user.setId(id);
        return repository.put(id, user) == null;
    }

    public Collection<User> findAll(){
        return  repository.values();
    }


}
