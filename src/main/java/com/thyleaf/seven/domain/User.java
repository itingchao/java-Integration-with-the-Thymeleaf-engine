package com.thyleaf.seven.domain;


import lombok.Data;

/**
 *
 */
@Data
public class User {
    private long id;
    private String name;
    private String email;



    public User() {
    }

    /**
     *
     * @param id
     * @param name
     * @param email
     */
    public User(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }


}
