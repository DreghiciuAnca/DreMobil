package com.example.dremobil.data;

import com.example.dremobil.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {
    private static String admin_username = "anca_dreghiciu_1997@yahoo.com";
    private static String admin_pass = "dreghiciuanca1";

    public Result<LoggedInUser> login(String username, String password) {


        if(username == admin_username && password == admin_pass) {
            try {
                // TODO: handle loggedInUser authentication

                LoggedInUser admin =
                        new LoggedInUser(
                                java.util.UUID.randomUUID().toString(),
                                " " + username);


                return new Result.Success<>(admin);

            } catch (Exception e) {
                return new Result.Error(new IOException("Error logging in administrator", e));
            }
        }
        else {
            try {
                LoggedInUser user = new LoggedInUser(java.util.UUID.randomUUID().toString(), " " + username);

                return new Result.Success<>(user);
            } catch (Exception e) {
                return new Result.Error(new IOException("Error logging in user",e));
            }
        }

    }

    public void logout() {
        // TODO: revoke authentication
    }
}
