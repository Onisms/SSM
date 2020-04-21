package com.galaxy.dao;

import com.galaxy.entity.TestBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestBeanDao {

    /*查询所有*/
    @Select("select * from testBean")
    public List<TestBean> queryAll();

    /*查询总数*/
    @Select("select count(*) from testBean")
    public int queryTotalCount();

    @Select("select * from testBean where id = #{id}")
    public TestBean queryById(int id);

    /*插入--增*/
    @Insert("insert into testBean values(0,#{name},#{password})")
    public void insert(TestBean testBean);

    /*删除*/
    @Delete("delete from testBean where id = #{id}")
    public void delete(int id);

    /*更新   改 */
    @Update("update testBean set name=#{name},password=#{password} where id = #{id}")
    public void update(TestBean testBean);

}
