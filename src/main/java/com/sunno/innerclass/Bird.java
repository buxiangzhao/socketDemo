package com.sunno.innerclass;

/**
 * Created by SQ_BXZ on 2018-02-11.
 */
public abstract class Bird {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int fly();
}
