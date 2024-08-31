package org.example;

import org.example.author.AuthorRepository;
import org.example.author.AuthorService;
import org.example.book.BookRepository;
import org.example.book.BookService;
import org.example.category.CategoryRepository;
import org.example.category.CategoryService;
import org.example.order.OrderRepository;
import org.example.order.OrderService;

import java.util.Scanner;

public class MainExecutor {
    public static void main(String[] args) {
        OrderService orderService = new OrderService(new OrderRepository());
        BookService bookService = new BookService(new BookRepository());
        CategoryService categoryService = new CategoryService(new CategoryRepository());
        AuthorService authorService = new AuthorService(new AuthorRepository());

        Scanner scanner = new Scanner(System.in);
        boolean getBack = true;
        System.out.println("Hello welcome to our page!");
        while (getBack) {
            System.out.println(
                    "\nHow can we asist you:" +
                            " \n 1.Show books for each category." +
                            "\n 2.Show books for each author." +
                            "\n 3.Make an order.");
            int response = scanner.nextInt();


            switch (response) {
                case 1:
                    System.out.println("This is the list of categories: " + categoryService.findAll());
                    System.out.println("Do you want to make another action? (yes/no)");
                    String yesOrNo = scanner.next();
                    if ("no".equalsIgnoreCase(yesOrNo)) {
                        getBack = false;
                    }
                    break;

                case 2:
                    System.out.println("This is the list of Authors: " + authorService.findAll()
                            + "\nChoose the author you want to see the books from by ID:");
                    int authorId = scanner.nextInt();
                    System.out.println(bookService.bookXauthor(authorId));
                    System.out.println("Do you want to make another action? (yes/no)");
                    yesOrNo = scanner.next();
                    if ("no".equalsIgnoreCase(yesOrNo)) {
                        getBack = false;
                    }
                    break;

                case 3:
                    orderService.addOrder();
                    System.out.println("Do you want to make another action? (yes/no)");
                    yesOrNo = scanner.next();
                    if ("no".equalsIgnoreCase(yesOrNo)) {
                        getBack = false;
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }

    }
}

