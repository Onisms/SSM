package com.galaxy.dao;

import com.galaxy.entity.Meeting;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeetingDao {
    @Select("<script>" +
            "select * from meeting " +
            "where 1=1 " +
            "<if test=\"title!=null and title!=''\">" +
            "<bind title = \"mTitle\" value = \"'%' + title + '%'\" />" +
            " and name like #{mTitle}" +
            "</if>  order by id desc" +
            "</script>")
    public List<Meeting> queryAllByPage(String title);

    @Select("<script>" +
            "select count(*) from meeting " +
            "where 1=1 " +
            "<if test=\"title!=null and title!=''\">" +
            "<bind title = \"mTitle\" value = \"'%' + title + '%'\" />" +
            " and name like #{mTitle}" +
            "</if>  order by id desc" +
            "</script>")
    public int queryTotalCount(String title);

    @Insert("insert into meeting values(0, #{accountId}, #{startTime}, #{endTime}, #{title}, #{content}, #{address})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public void insert(Meeting meeting);

    @Delete("delete from meeting where id = #{id}")
    public void delete(int id);

    @Select("select * from meeting where id = #{id}")
    public Meeting queryById(int id);

    @Update("update meeting set startTime = #{startTime}, endTime=#{endTime}, title=#{title}, content=#{content}, address=#{address} where id=#{id}")
    public int update(Meeting meeting);



}
