package com.pgs.javadev.user;

import com.pgs.javadev.exception.NotFoundException;
import com.pgs.javadev.model.User;
import com.pgs.javadev.model.UserBuilder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {

    private Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());

    private AtomicLong idGenerator;

    public UserService() {
        Long id = idGenerator.getAndIncrement();
        users.put(id, new UserBuilder()
                .id(id)
                .firstName("Jan")
                .lastName("Kowalski")
                .displayName("J Kowalski")
                .email("jkowalski@pgs-soft.com")
                .createUser());
        id = idGenerator.getAndIncrement();
        users.put(id, new UserBuilder()
                .id(id)
                .firstName("Zenon")
                .lastName("Martyniuk")
                .displayName("Z Martyniuk")
                .email("zmartyniuk@pgs-soft.com")
                .createUser());
        id = idGenerator.getAndIncrement();
        users.put(id, new UserBuilder()
                .id(id)
                .firstName("Andrzej")
                .lastName("Bolanowski")
                .displayName("A Bolanowski")
                .email("abolanowski@pgs-soft.com")
                .createUser());
    }

    public User addUser(User user) {
        user.setId(idGenerator.incrementAndGet());
        users.put(user.getId(), user);
        return user;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public User getDetails(Long id) {
        User user = users.get(id);
        if (user == null) {
            throw new NotFoundException();
        }
        return user;
    }

    public User updateUser(Long id, User user) {
        if (!users.containsKey(id)) {
            throw new NotFoundException();
        }

        user.setId(id);
        users.put(id, user);
        return user;
    }

    public User deleteUser(Long id) {
        if (!users.containsKey(id)) {
            throw new NotFoundException();
        }

        User removedUser = users.remove(id);
        return removedUser;
    }




}
