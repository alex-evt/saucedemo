package org.tms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class User {

    private String login = "standard_user";
    private String password = "secret_sauce";
//    private String login = System.getenv("LOGIN");
//    private String password = System.getenv("PASSWORD");


    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

}
