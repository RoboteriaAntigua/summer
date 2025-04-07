package roboto.machineCruds.auth.request;

import lombok.Data;

@Data
public class ApiRequest {

    private String username;
    private String email;
    private String password;
    private String message;

    public Boolean validate() {

        if (this.email == null || this.email.isBlank()) {
            this.message = this.message + "you should enter the email";
            return false;
        }

        if (this.password == null || this.email.isBlank()) {
            this.message = this.message + "You should enter the password";
            return false;
        }

        return true;
    }

}