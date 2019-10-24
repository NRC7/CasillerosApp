package org.example.casillerosapp.models;
import java.io.Serializable;

public class Locker implements Serializable {

    private int identifier;
    private String status;
    private boolean isAvailable;
    private String user;
    private String date;

    public Locker() {
    }

    public Locker(int identifier, String status, boolean isAvailable, String user, String date) {
        this.identifier = identifier;
        this.status = status;
        this.isAvailable = isAvailable;
        this.user = user;
        this.date = date;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
