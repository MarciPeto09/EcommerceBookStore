package org.example.user;

import org.example.order.OrderEntity;
import org.example.order.OrderRepository;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void addUser(UserEntity user){
        userRepository.add(user);
    }


    public void removeOrder(int id){
        userRepository.remove(id);
    }

    public UserEntity findByNameObject(String name){
        return userRepository.findByNameObject(name);
    }

    public Boolean findByName(String name){
        return userRepository.findByName(name);
    }

    public UserEntity addUserAuthentication(){

        UserService userService = new UserService(new UserRepository());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Put your user name:");
        String userName = scanner.next();;

        UserEntity user = null;

        if (userService.findByName(userName)) {

            int passAttemps = 3;
            boolean values = false;
            System.out.println("Put your password:");
            while (passAttemps > 0 && values == false) {
                String password = scanner.next();

                if (userService.findByPassword(password)) {
                    values = true;
                    user = userService.findByNameObject(userName);
                } else {

                    passAttemps -= 1;
                    if (passAttemps == 0) {
                        System.out.println("You Exited!!");
                        break;
                    }else{
                        System.out.println("Try again!");
                    }

                }
            }
        }
        return user;
    }
    public Boolean findByPassword(String password){
        return userRepository.findByPassword(password);
    }

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public void upDate(int id, UserEntity user){
        userRepository.update(id, user);
    }
}
