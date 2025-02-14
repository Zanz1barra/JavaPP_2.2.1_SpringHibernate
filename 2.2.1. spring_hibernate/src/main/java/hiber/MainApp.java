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
                        new Car("Modeeel", 666L)
                ),
                new User(
                        "User2",
                        "Lastname2",
                        "user2@mail.ru",
                        new Car("Moodoom", 696L)
                ),
                new User(
                        "User3",
                        "Lastname3",
                        "user3@mail.ru",
                        new Car("Leedeel", 969L)
                ),
                new User(
                        "User4",
                        "Lastname4",
                        "user4@mail.ru",
                        new Car("Leeedom", 999L)
                )
        };

        for (User user : addedUsers) {
            userService.add(user);
        }

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println();
            System.out.println(user);
        }

        System.out.println();
        Long seriesCriteria = 999L;
        String modelCriteria = "Leeedom";
        User findedUser = userService.findUserByCar(seriesCriteria, modelCriteria);
        if (findedUser == null) {
            System.out.println("User with Car (Model: " + modelCriteria + "; Series: " + seriesCriteria + ") not found");
        } else {
            System.out.println("User with Car (Model: " + modelCriteria + "; Series: " + seriesCriteria + ") founded:");
            System.out.println(findedUser);
        }

        context.close();
    }
}
