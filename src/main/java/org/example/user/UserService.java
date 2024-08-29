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

    public void addUser(UserEntity user){
        userRepository.addUser(user);
    }

    public void removeOrder(int id){
        userRepository.removeUser(id);
    }

    public UserEntity findByNameObject(String name){
        return userRepository.findByNameObject(name);
    }

    public Boolean findByName(String name){
        return userRepository.findByName(name);
    }

    public Boolean findByPassword(String password){
        return userRepository.findByPassword(password);
    }

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public void upDate(int id, UserEntity user){
        userRepository.upDate(id, user);
    }
}
