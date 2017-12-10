package com.nyc.in_class_dec_10_four;

import java.util.ArrayList;

/**
 * Created by Wayne Kellman on 12/10/17.
 */

public class BirdModel {

    private String family;
    private ArrayList<String> members;

    public BirdModel(String family) {
        this.family = family;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public ArrayList<String> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<String> members) {
        this.members = members;
    }
}
