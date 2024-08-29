package org.example;


import org.example.author.AuthorEntity;
import org.example.author.AuthorNationality;
import org.example.author.AuthorRepository;
import org.example.author.AuthorService;
import org.example.book.BookEntity;
import org.example.book.BookRepository;
import org.example.book.BookService;
import org.example.category.CategoryEntity;
import org.example.category.CategoryRepository;
import org.example.category.CategoryService;
import org.example.order.OrderEntity;
import org.example.order.OrderRepository;
import org.example.order.OrderService;
import org.example.user.UserEntity;
import org.example.user.UserRepository;
import org.example.user.UserService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {


//        //Krijimi i objekteve per tabelen author
//        AuthorEntity author1 = new AuthorEntity("J.K.", "Rowling", AuthorNationality.UK, LocalDate.of(1965, 7, 31), null);
//        AuthorEntity author2 = new AuthorEntity("George", "Orwell", AuthorNationality.UK, LocalDate.of(1903, 6, 25), null);
//        AuthorEntity author3 = new AuthorEntity("Mark", "Twain", AuthorNationality.USA, LocalDate.of(1835, 11, 30), null);
//        AuthorEntity author4 = new AuthorEntity("Jane", "Austen", AuthorNationality.UK, LocalDate.of(1775, 12, 16), null);
//        AuthorEntity author5 = new AuthorEntity("Ismail", "Kadare", AuthorNationality.Albanian, LocalDate.of(1936, 1, 28), null);
//        AuthorEntity author6 = new AuthorEntity("Gabriel", "Garcia Marquez", AuthorNationality.Else, LocalDate.of(1927, 3, 6), null);
//        AuthorEntity author7 = new AuthorEntity("Haruki", "Murakami", AuthorNationality.Cinese, LocalDate.of(1949, 1, 12), null);
//        AuthorEntity author8 = new AuthorEntity("Dante", "Alighieri", AuthorNationality.Italian, LocalDate.of(1265, 5, 21), null);
//        AuthorEntity author9 = new AuthorEntity("Fyodor", "Dostoevsky", AuthorNationality.Russian, LocalDate.of(1821, 11, 11), null);
//        AuthorEntity author10 = new AuthorEntity("Aristophanes", "Sophocles", AuthorNationality.Greek, LocalDate.of(-450, 1, 1), null);
//        AuthorEntity author11 = new AuthorEntity("Gunter", "Grass", AuthorNationality.German, LocalDate.of(1927, 10, 16), null);
//        AuthorEntity author12 = new AuthorEntity("Simone", "de Beauvoir", AuthorNationality.French, LocalDate.of(1908, 1, 9), null);
//        AuthorEntity author13 = new AuthorEntity("Homer", "Unknown", AuthorNationality.Greek, LocalDate.of(-800, 1, 1), null);
//        AuthorEntity author14 = new AuthorEntity("Virginia", "Woolf", AuthorNationality.UK, LocalDate.of(1882, 1, 25), null);
//        AuthorEntity author15 = new AuthorEntity("James", "Joyce", AuthorNationality.UK, LocalDate.of(1882, 2, 2), null);
//        AuthorEntity author16 = new AuthorEntity("Franz", "Kafka", AuthorNationality.German, LocalDate.of(1883, 7, 3), null);
//        AuthorEntity author17 = new AuthorEntity("Elena", "Ferrante", AuthorNationality.Italian, LocalDate.of(1943, 10, 10), null);
//        AuthorEntity author18 = new AuthorEntity("Margaret", "Atwood", AuthorNationality.Else, LocalDate.of(1939, 11, 18), null);
//        AuthorEntity author19 = new AuthorEntity("Pablo", "Neruda", AuthorNationality.Else, LocalDate.of(1904, 7, 12), null);
//        AuthorEntity author20 = new AuthorEntity("Albert", "Camus", AuthorNationality.French, LocalDate.of(1913, 11, 7), null);
//
//        //Krijimi i objeckteve Category
//        CategoryEntity fiction = new CategoryEntity("Fiction");
//        CategoryEntity drama = new CategoryEntity("Drama");
//        CategoryEntity classic = new CategoryEntity("Classic");
//        CategoryEntity poetry = new CategoryEntity("Poetry");
//        //Mbushja e tabeles category me te dhena
//        CategoryService categoryService = new CategoryService(new CategoryRepository());
//        categoryService.addCategory(fiction);
//        categoryService.addCategory(drama);
//        categoryService.addCategory(classic);
//        categoryService.addCategory(poetry);
//
//        //Krijimi i objeckteve Book
//        BookEntity book1 = new BookEntity("Harry Potter and the Philosopher's Stone", 29.99, Arrays.asList(author1), fiction, null);
//        BookEntity book2 = new BookEntity("1984", 19.99, Arrays.asList(author2), fiction, null);
//        BookEntity book3 = new BookEntity("Adventures of Huckleberry Finn", 15.99, Arrays.asList(author3), classic, null);
//        BookEntity book4 = new BookEntity("Pride and Prejudice", 17.99, Arrays.asList(author4), classic, null);
//        BookEntity book5 = new BookEntity("The General of the Dead Army", 13.99, Arrays.asList(author5), drama, null);
//        BookEntity book6 = new BookEntity("One Hundred Years of Solitude", 22.99, Arrays.asList(author6), fiction, null);
//        BookEntity book7 = new BookEntity("Kafka on the Shore", 18.99, Arrays.asList(author7), fiction, null);
//        BookEntity book8 = new BookEntity("The Divine Comedy", 24.99, Arrays.asList(author8), poetry, null);
//        BookEntity book9 = new BookEntity("Crime and Punishment", 20.99, Arrays.asList(author9), classic, null);
//        BookEntity book10 = new BookEntity("Lysistrata", 12.99, Arrays.asList(author10), drama, null);
//        BookEntity book11 = new BookEntity("The Tin Drum", 21.99, Arrays.asList(author11), drama, null);
//        BookEntity book12 = new BookEntity("The Second Sex", 23.99, Arrays.asList(author12), fiction, null);
//        BookEntity book13 = new BookEntity("The Iliad", 27.99, Arrays.asList(author13), poetry, null);
//        BookEntity book14 = new BookEntity("To the Lighthouse", 16.99, Arrays.asList(author14), fiction, null);
//        BookEntity book15 = new BookEntity("Ulysses", 30.99, Arrays.asList(author15), fiction, null);
//        BookEntity book16 = new BookEntity("The Trial", 14.99, Arrays.asList(author16), fiction, null);
//        BookEntity book17 = new BookEntity("My Brilliant Friend", 18.99, Arrays.asList(author17), fiction, null);
//        BookEntity book18 = new BookEntity("The Handmaid's Tale", 19.99, Arrays.asList(author18), fiction, null);
//        BookEntity book19 = new BookEntity("Twenty Love Poems and a Song of Despair", 9.99, Arrays.asList(author19), poetry, null);
//        BookEntity book20 = new BookEntity("The Stranger", 14.99, Arrays.asList(author20), classic, null);
//
//        //Krijimi i objekteve user
//        UserEntity user1 = new UserEntity("John", "Doe", "john.doe@example.com", "password123", LocalDate.of(2020, 5, 1), null);
//        UserEntity user2 = new UserEntity("Jane", "Smith", "jane.smith@example.com", "securepass456", LocalDate.of(2021, 6, 15), null);
//        UserEntity user3 = new UserEntity("Alice", "Johnson", "alice.johnson@example.com", "alice789", LocalDate.of(2022, 3, 10), null);
//        UserEntity user4 = new UserEntity("Robert", "Brown", "robert.brown@example.com", "robertpass321", LocalDate.of(2023, 2, 20), null);
//        UserEntity user5 = new UserEntity("Emily", "Davis", "emily.davis@example.com", "emilypass654", LocalDate.of(2021, 7, 8), null);
//        UserEntity user6 = new UserEntity("Michael", "Wilson", "michael.wilson@example.com", "michaelpass987", LocalDate.of(2023, 5, 14), null);
//        UserEntity user7 = new UserEntity("Jessica", "Martinez", "jessica.martinez@example.com", "jessica123", LocalDate.of(2022, 8, 25), null);
//        UserEntity user8 = new UserEntity("David", "Anderson", "david.anderson@example.com", "davidpass321", LocalDate.of(2020, 9, 30), null);
//        UserEntity user9 = new UserEntity("Laura", "Thomas", "laura.thomas@example.com", "laura456", LocalDate.of(2021, 1, 11), null);
//        UserEntity user10 = new UserEntity("Chris", "Jackson", "chris.jackson@example.com", "chrispass789", LocalDate.of(2023, 4, 17), null);
//        UserEntity user11 = new UserEntity("Karen", "White", "karen.white@example.com", "karenpass101", LocalDate.of(2022, 10, 4), null);
//        UserEntity user12 = new UserEntity("Daniel", "Harris", "daniel.harris@example.com", "daniel202", LocalDate.of(2020, 11, 22), null);
//        UserEntity user13 = new UserEntity("Patricia", "Clark", "patricia.clark@example.com", "patricia303", LocalDate.of(2021, 12, 6), null);
//        UserEntity user14 = new UserEntity("Thomas", "Lewis", "thomas.lewis@example.com", "thomas404", LocalDate.of(2022, 2, 18), null);
//        UserEntity user15 = new UserEntity("Nancy", "Walker", "nancy.walker@example.com", "nancy505", LocalDate.of(2023, 3, 9), null);
//        UserEntity user16 = new UserEntity("Peter", "Hall", "peter.hall@example.com", "peter606", LocalDate.of(2021, 8, 13), null);
//        UserEntity user17 = new UserEntity("Linda", "Allen", "linda.allen@example.com", "linda707", LocalDate.of(2022, 5, 21), null);
//        UserEntity user18 = new UserEntity("Steven", "Young", "steven.young@example.com", "steven808", LocalDate.of(2020, 6, 26), null);
//        UserEntity user19 = new UserEntity("Catherine", "King", "catherine.king@example.com", "catherine909", LocalDate.of(2021, 4, 7), null);
//        UserEntity user20 = new UserEntity("Mark", "Scott", "mark.scott@example.com", "mark010", LocalDate.of(2023, 1, 2), null);
//        UserEntity user21 = new UserEntity("Sophia", "Green", "sophia.green@example.com", "sophia111", LocalDate.of(2022, 7, 19), null);
//        UserEntity user22 = new UserEntity("Benjamin", "Baker", "benjamin.baker@example.com", "benjamin222", LocalDate.of(2020, 3, 24), null);
//        UserEntity user23 = new UserEntity("Megan", "Adams", "megan.adams@example.com", "megan333", LocalDate.of(2021, 9, 29), null);
//        UserEntity user24 = new UserEntity("Alexander", "Nelson", "alexander.nelson@example.com", "alexander444", LocalDate.of(2023, 5, 18), null);
//        UserEntity user25 = new UserEntity("Grace", "Carter", "grace.carter@example.com", "grace555", LocalDate.of(2022, 11, 15), null);
//        UserEntity user26 = new UserEntity("Elijah", "Mitchell", "elijah.mitchell@example.com", "elijah666", LocalDate.of(2020, 2, 23), null);
//        UserEntity user27 = new UserEntity("Hannah", "Perez", "hannah.perez@example.com", "hannah777", LocalDate.of(2021, 10, 5), null);
//        UserEntity user28 = new UserEntity("Lucas", "Roberts", "lucas.roberts@example.com", "lucas888", LocalDate.of(2023, 8, 1), null);
//        UserEntity user29 = new UserEntity("Zoe", "Turner", "zoe.turner@example.com", "zoe999", LocalDate.of(2022, 1, 27), null);
//        UserEntity user30 = new UserEntity("Matthew", "Phillips", "matthew.phillips@example.com", "matthew100", LocalDate.of(2020, 12, 12), null);
//        UserEntity user31 = new UserEntity("Ava", "Campbell", "ava.campbell@example.com", "ava121", LocalDate.of(2021, 7, 3), null);
//        UserEntity user32 = new UserEntity("Ethan", "Parker", "ethan.parker@example.com", "ethan232", LocalDate.of(2023, 6, 30), null);
//        UserEntity user33 = new UserEntity("Olivia", "Evans", "olivia.evans@example.com", "olivia343", LocalDate.of(2022, 9, 10), null);
//        UserEntity user34 = new UserEntity("William", "Edwards", "william.edwards@example.com", "william454", LocalDate.of(2020, 4, 14), null);
//        UserEntity user35 = new UserEntity("Emma", "Collins", "emma.collins@example.com", "emma565", LocalDate.of(2021, 3, 16), null);
//        UserEntity user36 = new UserEntity("Joseph", "Stewart", "joseph.stewart@example.com", "joseph676", LocalDate.of(2023, 11, 23), null);
//        UserEntity user37 = new UserEntity("Ella", "Morris", "ella.morris@example.com", "ella787", LocalDate.of(2022, 12, 31), null);
//        UserEntity user38 = new UserEntity("Daniel", "Rogers", "daniel.rogers@example.com", "daniel898", LocalDate.of(2020, 10, 20), null);
//        UserEntity user39 = new UserEntity("Sophia", "Reed", "sophia.reed@example.com", "sophia909", LocalDate.of(2021, 11, 17), null);
//        UserEntity user40 = new UserEntity("Liam", "Cook", "liam.cook@example.com", "liam010", LocalDate.of(2023, 7, 6), null);
//        //Mbushja e tabeles user me te dhena
//        UserService userService = new UserService(new UserRepository());
//        userService.addUser(user1);
//        userService.addUser(user2);
//        userService.addUser(user3);
//        userService.addUser(user4);
//        userService.addUser(user5);
//        userService.addUser(user6);
//        userService.addUser(user7);
//        userService.addUser(user8);
//        userService.addUser(user9);
//        userService.addUser(user10);
//        userService.addUser(user11);
//        userService.addUser(user12);
//        userService.addUser(user13);
//        userService.addUser(user14);
//        userService.addUser(user15);
//        userService.addUser(user16);
//        userService.addUser(user17);
//        userService.addUser(user18);
//        userService.addUser(user19);
//        userService.addUser(user20);
//        userService.addUser(user21);
//        userService.addUser(user22);
//        userService.addUser(user23);
//        userService.addUser(user24);
//        userService.addUser(user25);
//        userService.addUser(user26);
//        userService.addUser(user27);
//        userService.addUser(user28);
//        userService.addUser(user29);
//        userService.addUser(user30);
//        userService.addUser(user31);
//        userService.addUser(user32);
//        userService.addUser(user33);
//        userService.addUser(user34);
//        userService.addUser(user35);
//        userService.addUser(user36);
//        userService.addUser(user37);
//        userService.addUser(user38);
//        userService.addUser(user39);
//        userService.addUser(user40);
//
//
//        //Mbushja e tabeles "author_book"
//        author1.setListOfBookXAuthor(Arrays.asList(book1));
//        author2.setListOfBookXAuthor(Arrays.asList(book2));
//        author3.setListOfBookXAuthor(Arrays.asList(book3));
//        author4.setListOfBookXAuthor(Arrays.asList(book4));
//        author5.setListOfBookXAuthor(Arrays.asList(book5));
//        author6.setListOfBookXAuthor(Arrays.asList(book6));
//        author7.setListOfBookXAuthor(Arrays.asList(book7));
//        author8.setListOfBookXAuthor(Arrays.asList(book8));
//        author9.setListOfBookXAuthor(Arrays.asList(book9));
//        author10.setListOfBookXAuthor(Arrays.asList(book10));
//        author11.setListOfBookXAuthor(Arrays.asList(book11));
//        author12.setListOfBookXAuthor(Arrays.asList(book12));
//        author13.setListOfBookXAuthor(Arrays.asList(book13));
//        author14.setListOfBookXAuthor(Arrays.asList(book14));
//        author15.setListOfBookXAuthor(Arrays.asList(book15));
//        author16.setListOfBookXAuthor(Arrays.asList(book16));
//        author17.setListOfBookXAuthor(Arrays.asList(book17));
//        author18.setListOfBookXAuthor(Arrays.asList(book18));
//        author19.setListOfBookXAuthor(Arrays.asList(book19));
//        author20.setListOfBookXAuthor(Arrays.asList(book20));
//
//        book1.setListOfAuthorsXBook(Arrays.asList(author1));
//        book2.setListOfAuthorsXBook(Arrays.asList(author2));
//        book3.setListOfAuthorsXBook(Arrays.asList(author3));
//        book4.setListOfAuthorsXBook(Arrays.asList(author4));
//        book5.setListOfAuthorsXBook(Arrays.asList(author5));
//        book6.setListOfAuthorsXBook(Arrays.asList(author6));
//        book7.setListOfAuthorsXBook(Arrays.asList(author7));
//        book8.setListOfAuthorsXBook(Arrays.asList(author8));
//        book9.setListOfAuthorsXBook(Arrays.asList(author9));
//        book10.setListOfAuthorsXBook(Arrays.asList(author10));
//        book11.setListOfAuthorsXBook(Arrays.asList(author11));
//        book12.setListOfAuthorsXBook(Arrays.asList(author12));
//        book13.setListOfAuthorsXBook(Arrays.asList(author13));
//        book14.setListOfAuthorsXBook(Arrays.asList(author14));
//        book15.setListOfAuthorsXBook(Arrays.asList(author15));
//        book16.setListOfAuthorsXBook(Arrays.asList(author16));
//        book17.setListOfAuthorsXBook(Arrays.asList(author17));
//        book18.setListOfAuthorsXBook(Arrays.asList(author18));
//        book19.setListOfAuthorsXBook(Arrays.asList(author19));
//        book20.setListOfAuthorsXBook(Arrays.asList(author20));
//
//
//        //Mbushja e tabeles author me te dhena
//        AuthorService authorService = new AuthorService(new AuthorRepository());
//        authorService.addAuthor(author1);
//        authorService.addAuthor(author2);
//        authorService.addAuthor(author3);
//        authorService.addAuthor(author4);
//        authorService.addAuthor(author5);
//        authorService.addAuthor(author6);
//        authorService.addAuthor(author7);
//        authorService.addAuthor(author8);
//        authorService.addAuthor(author9);
//        authorService.addAuthor(author10);
//        authorService.addAuthor(author11);
//        authorService.addAuthor(author12);
//        authorService.addAuthor(author13);
//        authorService.addAuthor(author14);
//        authorService.addAuthor(author15);
//        authorService.addAuthor(author16);
//        authorService.addAuthor(author17);
//        authorService.addAuthor(author18);
//        authorService.addAuthor(author19);
//        authorService.addAuthor(author20);
//
//
//        //Mbushja e tabeles book me te dhena
//        BookService bookService = new BookService(new BookRepository());
////        bookService.addBook(book1);
////        bookService.addBook(book2);
////        bookService.addBook(book3);
////        bookService.addBook(book4);
////        bookService.addBook(book5);
////        bookService.addBook(book6);
////        bookService.addBook(book7);
////        bookService.addBook(book8);
////        bookService.addBook(book9);
////        bookService.addBook(book10);
////        bookService.addBook(book11);
////        bookService.addBook(book12);
////        bookService.addBook(book13);
////        bookService.addBook(book14);
////        bookService.addBook(book15);
////        bookService.addBook(book16);
////        bookService.addBook(book17);
////        bookService.addBook(book18);
////        bookService.addBook(book19);
////        bookService.addBook(book20);

        OrderService orderService = new OrderService(new OrderRepository());
        orderService.addOrder();


    }
}