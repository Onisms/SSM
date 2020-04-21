package com.galaxy.entity;

import java.io.Serializable;

/**
 * (Testbean)实体类
 *
 * @author makejava
 * @since 2020-04-16 15:33:16
 */
public class TestBean implements Serializable {
    private static final long serialVersionUID = 475132308599088990L;
    
    private Integer id;
    
    private String name;
    
    private String password;

    @Override
    public String toString() {
        return "TestBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}