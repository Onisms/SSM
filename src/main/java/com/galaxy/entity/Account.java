package com.galaxy.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Account)实体类
 *
 * @author makejava
 * @since 2020-04-20 14:56:21
 */
public class Account implements Serializable {
    private static final long serialVersionUID = -65367084922581333L;
    
    private Integer id;
    
    private String name;
    
    private String password;

    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
    //登录时间
    private Date accessTime;
    //删除标记
    private boolean deleteFlag;
    //备注
    private String remark;

    @Override
    public String toString() {
        return "Account{" +
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