package com.galaxy.entity;

import java.io.Serializable;

/**
 * (Emp)实体类
 *
 * @author makejava
 * @since 2020-04-23 21:05:18
 */
public class Emp implements Serializable {
    private static final long serialVersionUID = 278286773209344536L;
    /**
    * 员工id
    */
    private Integer id;
    /**
    * 员工编号
    */
    private String eNo;
    /**
    * 员工姓名
    */
    private String name;
    /**
    * 员工性别
    */
    private String sex;
    /**
    * 员工电话
    */
    private String phone;
    /**
    * 所属部门
    */
    private String dept;
    /**
    * 员工角色
    */
    private String role;
    /**
    * 员工状态
    */
    private String state;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String geteNo() {
        return eNo;
    }

    public void seteNo(String eNo) {
        this.eNo = eNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", eNo='" + eNo + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", dept='" + dept + '\'' +
                ", role='" + role + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}