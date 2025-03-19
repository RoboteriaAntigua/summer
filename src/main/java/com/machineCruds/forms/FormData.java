package com.machineCruds.forms;

public class FormData {
    
    private String name;

    private String email;
    
    private String password;
    
    private String message = "* ";

    private String confirmate;

    public String getConfirmate () {
        return this.confirmate;
    }

    public void setConfirmate(String confirmate) {
        this.confirmate = confirmate;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getMessage() {
        return this.message;
    }


      public Boolean validateRegistration ( ) {

        if( this.email == null || this.email.isBlank()) {
            this.message = this.message + "You should enter the email";
            return false;
        }

        if( this.password == null || this.email.isBlank()) {
            this.message = this.message + "You should enter the password";
            return false;
        }

        if( ! this.confirmate.equals( this.password ) ) {
            this.message = this.message + "The passwords should matches";
            return false;
        }

        return true;
    }

}