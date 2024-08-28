package org.example.user;

import org.example.order.OrderEntity;
import org.example.order.OrderRepository;

import java.util.List;
import java.util.UUID;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addOrder(UserEntity user){
        userRepository.addUser(user);
    }

    public void removeOrder(UUID id){
        userRepository.removeUser(id);
    }

    public UserEntity findById(UUID id){
        return userRepository.findById(id);
    }

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public void upDate(UUID id, UserEntity user){
        userRepository.upDate(id, user);
    }
}
