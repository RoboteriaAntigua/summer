package roboto.machineCruds.request;

public class ApiRequest {

    private String name;
    private String email;
    private String password;
    private String message;

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getMessage() {
        return this.message;
    }

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