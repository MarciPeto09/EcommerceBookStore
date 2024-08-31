package org.example.order;

import org.example.book.BookEntity;
import org.example.book.BookRepository;
import org.example.book.BookService;
import org.example.user.UserEntity;
import org.example.user.UserRepository;
import org.example.user.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void addOrder( UserEntity user) {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService(new UserRepository());
        BookService bookService = new BookService(new BookRepository());

        OrderEntity order = new OrderEntity();
        order.setData(LocalDate.now());
        order.setStatus("Aktive");
        order.setUser(user);

        if (user != null) {
            System.out.println("Welcome!!");
            System.out.println("How can we serve you?" +
                    "\n 1.See  the list of all books." +
                    "\n 2.Make an order.");
            int response = scanner.nextInt();
            int orderTotal = 0;

            switch (response) {
                case 1:
                    System.out.println("List of books;");
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
//
            //Ruajtja e order ne database
            orderRepository.add(order);

            System.out.println("Your order is ready:" + order + "\nIt will be delivered after 7 days: " + LocalDate.now().plusDays(7) + "\nThe TOTAL: " + orderTotal + " Leke");


        }


    }
    public void removeOrder(int id){
        orderRepository.remove(id);
    }

    public OrderEntity findById(int id){
        return orderRepository.findById(id);
    }

    public List<OrderEntity> findAll(){
        return orderRepository.findAll();
    }

    public void upDate(int id, OrderEntity order){
        orderRepository.update(id, order);
    }

    public List<OrderEntity> orderOfUser(UserEntity user){
        return orderRepository.orderOfUser(user);
    }
}
