package com.nakarin.arsenalpc.firebasebird.utility;

/**
 * Created by Arsenal Pc on 26-Nov-17.
 */

public class UserModel {
    private String uidString, nameDisplayString;

    public UserModel() {
    } //For getter

    public UserModel(String uidString) {
        this.uidString = uidString;
        this.nameDisplayString = nameDisplayString;
    } //for setter

    public String getUidString() {
        return uidString;
    }

    public void setUidString(String uidString) {
        this.uidString = uidString;
    }

    public String getNameDisplayString() {
        return nameDisplayString;
    }

    public void setNameDisplayString(String nameDisplayString) {
        this.nameDisplayString = nameDisplayString;
    }
}//Main Clas
