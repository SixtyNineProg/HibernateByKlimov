import dto.Auto;
import dto.User;
import service.UserService;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserService();
        User user = new User("Masha",26);
        userService.saveUser(user);
        Auto ferrari = new Auto("Ferrari", "red");
        ferrari.setUser(user);
        user.addAuto(ferrari);
        Auto ford = new Auto("Ford", "black");
        ford.setUser(user);
        user.addAuto(ford);
        userService.updateUser(user);

/*
        UserService userService = new UserService();
        User user = userService.findById(1);
        if (user != null) {
            System.out.println(user);
            //System.out.println("deleted!");
            userService.deleteUser(user);
        }else {
            System.out.println("can't find user");
        }
/*
        UserService userService = new UserService();
        User user = new User("Masha",26);
        userService.saveUser(user);
        Auto ferrari = new Auto("Ferrari", "red");
        user.addAuto(ferrari);
        Auto ford = new Auto("Ford", "black");
        ford.setUser(user);
        user.addAuto(ford);
        userService.updateUser(user);
        user.setName("Sasha");
        userService.updateUser(user);
        userService.deleteUser(user);
 */
    }
}
