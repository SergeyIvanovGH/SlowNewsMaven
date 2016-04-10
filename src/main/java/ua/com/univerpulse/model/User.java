package ua.com.univerpulse.model;

<<<<<<< HEAD
=======
/**
 * Created by svivanov on 28.03.16.
 */
>>>>>>> 287e58700abc6d8c58f69a7e56e090314014f39d
public class User {
    private String name;
    private String login;
    private String password;

    public User() {
    }

    public User(String name, String login, String password) {
        this.login = login;
        this.name = name;
        setPassword(password);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = HashValue.generate(password);
    }
}
