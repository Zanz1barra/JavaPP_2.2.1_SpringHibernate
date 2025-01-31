package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User[] addedUsers = {
                new User(
                        "User1",
                        "Lastname1",
                        "user1@mail.ru",
                        new Car("Modeeel", 666)
                ),
                new User(
                        "User2",
                        "Lastname2",
                        "user2@mail.ru"
                ),
                new User(
                        "User3",
                        "Lastname3",
                        "user3@mail.ru"
                ),
                new User(
                        "User4",
                        "Lastname4",
                        "user4@mail.ru",
                        new Car("Leeedom", 999)
                )
        };

        for (User user : addedUsers) {
            userService.add(user);
        }

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println();
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
        }

        context.close();
    }
}
