package com.pgs.javadev.model;

public class UserBuilder {
    private Long id;
    private String firstName;
    private String lastName;
    private String displayName;
    private String email;

    public UserBuilder id(final Long id) {
        this.id = id;
        return this;
    }

    public UserBuilder firstName(final String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder lastName(final String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder displayName(final String displayName) {
        this.displayName = displayName;
        return this;
    }

    public UserBuilder email(final String email) {
        this.email = email;
        return this;
    }

    public User createUser() {
        return new User(id, firstName, lastName, displayName, email);
    }
}