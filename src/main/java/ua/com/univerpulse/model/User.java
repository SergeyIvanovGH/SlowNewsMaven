package ua.com.univerpulse.model;

import ua.com.univerpulse.dao.IdentifierDao;

public class User implements IdentifierDao<Integer> {
    private int id;
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

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setPasswordNoConvert(String password) {
        this.password = password;
    }
}
