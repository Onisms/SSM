package com.galaxy.dao;

import com.galaxy.entity.Dept;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptDao {

   // @Select("select * from dept order by id desc")
    @Select("<script>" +
            "select * from dept " +
            "where 1=1" +
            "<if test=\"name!=null and name!=''\">" +
            "<bind name = \"dName\" value = \"'%' + name + '%'\" />" +
            " and name like #{dName}" +
            "</if>  order by id desc" +
            "</script>")
    public List<Dept> queryAllByPage(String name);

    @Select("<script>" +
            "select count(*) from dept " +
            "where 1=1" +
            "<if test=\"name!=null and name!=''\">" +
            "<bind name = \"dName\" value = \"'%' + name + '%'\" />" +
            " and name like #{dName}" +
            "</if> order by id desc" +
            "</script>")
    public int queryTotalCount(String name);

    @Insert("insert into dept values(0, #{departNo}, #{name}, #{description})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public void insert(Dept dept);

    @Delete("delete from dept where id = #{id}")
    public void delete(int id);

    @Select("select * from dept where id = #{id}")
    public Dept queryById(int id);

    @Update("update dept set name = #{name},description = #{description} where id = #{id}")
    public int update(Dept dept);


}
