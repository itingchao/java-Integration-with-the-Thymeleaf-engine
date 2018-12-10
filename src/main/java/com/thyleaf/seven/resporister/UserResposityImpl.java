package com.thyleaf.seven.resporister;

import com.thyleaf.seven.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserResposityImpl implements UserResposity {

    private static AtomicLong counter = new AtomicLong();
    private final ConcurrentMap<Long, User> userMap = new ConcurrentHashMap<>();
    @Override
    public User saveOrUpdateUser(User user) {

        Long id = user.getId();
        if (id ==null){ //新建
            id = counter.incrementAndGet();
            user.setId(id);

        }
        this.userMap.put(id, user);
        return user;
    }

    @Override
    public void deleteUser(long id) {
        this.userMap.remove(id);
    }

    @Override
    public User getUserById(long id) {

        return  this.userMap.get(id);
    }

    @Override
    public List<User> getUsers() {
        return new ArrayList<User>(this.userMap.values());
    }
}
