package com.example.covictory;

public class ModelClass {
    String name,contact,other;

    public ModelClass(String name, String contact, String other) {
        this.name = name;
        this.contact = contact;
        this.other = other;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
