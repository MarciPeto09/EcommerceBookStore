package org.example.order;

import org.example.book.BookEntity;
import org.example.book.BookRepository;
import org.example.book.BookService;
import org.example.category.CategoryEntity;
import org.example.category.CategoryRepository;
import org.example.user.UserRepository;
import org.example.user.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void addOrder() {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService(new UserRepository());

        OrderEntity order = new OrderEntity();
        order.setData(LocalDate.now());
        order.setStatus("Aktive");

        System.out.println("Enter your Username:");
        String userName = scanner.next();

        //User nuk mund te fusi me shume se 3 here password


        if (userService.findByName(userName)) {
            order.setUser(userService.findByNameObject(userName));
            int passAtemps = 3;
            boolean valueBoolean = false;
            while (passAtemps > 0 & valueBoolean == false ) {
                System.out.println("Enter your Password:");
                String password = scanner.next();
                int orderTotal = 0;
                if (userService.findByPassword(password)) {
                    valueBoolean = true;
                    System.out.println("Press:" +
                            "\n1. To see all the books we have" +
                            "\n2. To enter books on the order");
                    int option = scanner.nextInt();

                    //Krijimi i bookService
                    BookService bookService = new BookService(new BookRepository());

                    switch (option) {
                        case 1:
                            System.out.println(bookService.findAll());
                        case 2:
                            List<BookEntity> lista = new ArrayList<>();
                            System.out.println("How many books do you want to enter to the order?");
                            int numberOfBooks = scanner.nextInt();

                            for (int i = 0; i < numberOfBooks; i++) {
                                System.out.println("Give the title of book " + (i + 1));
                                lista.add(bookService.findByName(scanner.next()));
                            }

                            order.setBooks(lista);

                            for (int i = 0; i < lista.size(); i++) {
                                orderTotal += lista.get(i).getPrice();
                            }
                    }

                    System.out.println("In what address is the order to be delivered?");
                    order.setAdress(scanner.next());

                    //Ruajtja e order ne database
                    orderRepository.addOrder(order);

                    System.out.println("Your order is ready:" + order + "\nIt will be delivered after 7 days: " + LocalDate.now().plusDays(7) + "The TOTAL: " + orderTotal);
                } else {
                    passAtemps--;
                    if(passAtemps == 0){
                        System.out.println("You have reached the maximum number of attemps!!   \n You exited the program!");
                    }
                }

            }

        } else {
            System.out.println("Your username does not exist!");
        }

    }

    public void removeOrder(int id){
        orderRepository.removeOrder(id);
    }

    public OrderEntity findById(int id){
        return orderRepository.findById(id);
    }

    public List<OrderEntity> findAll(){
        return orderRepository.findAll();
    }

    public void upDate(int id, OrderEntity order){
        orderRepository.upDate(id, order);
    }
}
