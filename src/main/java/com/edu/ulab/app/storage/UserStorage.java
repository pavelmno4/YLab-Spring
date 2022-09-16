package com.edu.ulab.app.storage;

import com.edu.ulab.app.domain.User;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class UserStorage implements Storage<User, Long> {
    private final Map<Long, User> storage = new ConcurrentHashMap<>();

    @Override
    public User save(User entity) {
        storage.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public List<User> saveAll(Set<User> entities) {
        return entities.stream()
                .map(entity -> new AbstractMap.SimpleEntry<>(entity.getId(), entity))
                .peek(pair -> storage.put(pair.getKey(), pair.getValue()))
                .map(AbstractMap.SimpleEntry::getValue)
                .toList();
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.of(storage.get(id));
    }

    @Override
    public List<User> findAllById(Set<Long> ids) {
        return ids.stream()
                .map(storage::get)
                .toList();
    }

    @Override
    public void delete(User entity) {
        storage.remove(entity.getId());
    }

    @Override
    public void deleteById(Long id) {
        storage.remove(id);
    }
}