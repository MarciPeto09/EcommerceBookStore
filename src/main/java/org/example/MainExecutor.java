package org.example;

import org.example.author.AuthorRepository;
import org.example.author.AuthorService;
import org.example.book.BookRepository;
import org.example.book.BookService;
import org.example.category.CategoryRepository;
import org.example.category.CategoryService;
import org.example.order.OrderRepository;
import org.example.order.OrderService;
import org.example.user.UserEntity;
import org.example.user.UserRepository;
import org.example.user.UserService;

import java.util.Scanner;

public class MainExecutor {
    public static void main(String[] args) {
        OrderService orderService = new OrderService(new OrderRepository());
        BookService bookService = new BookService(new BookRepository());
        CategoryService categoryService = new CategoryService(new CategoryRepository());
        AuthorService authorService = new AuthorService(new AuthorRepository());
        UserService userService = new UserService(new UserRepository());

        Scanner scanner = new Scanner(System.in);
        boolean getBack = true;
        System.out.println("Hello welcome to our page!");
        UserEntity userEntity = userService.addUserAuthentication();

        while (userEntity == null) {
            System.out.println("This user does not exist!" +
                    "\n Try again!!");
            userEntity = userService.addUserAuthentication();
        }

        while (getBack) {
            System.out.println(
                    "\nHow can we asist you:" +
                            " \n 1.Show books for each category." +
                            "\n 2.Show books for each author." +
                            "\n 3.Make an order." +
                            "\n 4.Show me MY ORDERS." +
                            "\n 5.Delente an Order by ID");
            int response = scanner.nextInt();


            switch (response) {
                case 1:
                    System.out.println("This is the list of categories: " + categoryService.findAll());
                   getBack = getBackMethod(scanner);
                    break;

                case 2:
                    System.out.println("This is the list of Authors: " + authorService.findAll()
                            + "\nChoose the author you want to see the books from by ID:");
                    getBack = getBackMethod(scanner);
                    break;

                case 3:
                    orderService.addOrder(userEntity);
                    getBack = getBackMethod(scanner);
                    break;

                case 4:
                    System.out.println("Your orders.");
                    System.out.println(orderService.orderOfUser(userEntity));
                    getBack = getBackMethod(scanner);
                    break;

                case 5:
                    System.out.println("What order do you want to revert?" + orderService.findAll());
                    int idOrderToRevert = scanner.nextInt();
                    orderService.removeOrder(idOrderToRevert);
                    System.out.println("Your order was deleted with success!");
                    getBack = getBackMethod(scanner);
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }

        }


    }


    public static boolean getBackMethod(Scanner scanner) {
        System.out.println("Do you want to make another action? (yes/no)");
        String yesOrNo = scanner.next();
        if(yesOrNo.equalsIgnoreCase("no")){
            System.out.println("Goodbye and thankyou for choosing us! :*");
        }
        return !"no".equalsIgnoreCase(yesOrNo);

    }
}

