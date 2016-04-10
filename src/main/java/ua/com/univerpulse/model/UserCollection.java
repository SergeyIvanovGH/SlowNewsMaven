package ua.com.univerpulse.model;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
=======
/**
 * Created by svivanov on 29.03.16.
 */
>>>>>>> 287e58700abc6d8c58f69a7e56e090314014f39d
public class UserCollection {
    private static UserCollection ourInstance = new UserCollection();
    private List<User> users = new ArrayList<>();

    public static UserCollection getInstance() {
        return ourInstance;
    }

    private UserCollection() {
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        if (!isUserInList(user)) {
            this.users.add(user);
        }
    }

    /**
     * get User by login-identificator
     * @param login - login user
     * @return instance User if found, null - otherwise
     */
    public User getUser(String login) {
        for (User user : users) {
            if ( user.getLogin().equals(login) ) {
                return user;
            }
        }
        return null;
    }

    public boolean isUserInList(User user) {
        for (User userList : users) {
            if ( (userList.getName().equals(user.getName())) &&
                    (userList.getLogin().equals(user.getLogin())) &&
                    (userList.getPassword().equals(user.getPassword()))
                    ) {
                return true;
            }
        }
        return false;
    }

    public User identifyUser(String login, String password) {
        String hashPassword = HashValue.generate(password);
        for (User user : users) {
            if ( (user.getLogin().equals(login)) && (user.getPassword().equals(hashPassword)) ) {
                return user;
            }
        }
        return null;
    }
}
