package com.galaxy.entity;

import java.io.Serializable;

/**
 * 部门表(Dept)实体类
 *
 * @author makejava
 * @since 2020-04-21 20:18:06
 */
public class Dept implements Serializable {
    private static final long serialVersionUID = -37067397915261261L;
    /**
    * 唯一主键
    */
    private Integer id;
    /**
    * 部门编号
    */
    private String departNo;
    /**
    * 部门名称
    */
    private String name;
    /**
    * 部门描述
    */
    private String description;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartNo() {
        return departNo;
    }

    public void setDepartNo(String departNo) {
        this.departNo = departNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", departNo='" + departNo + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}