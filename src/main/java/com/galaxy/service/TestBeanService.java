package com.galaxy.service;

import com.galaxy.entity.TestBean;

import java.util.List;

public interface TestBeanService {

    public List<TestBean> queryAllPages(int current, int pageSize);

    public int queryTotalPages(int pageSize);

    public TestBean queryById(int id);

    /*插入--增*/
    public void insert(TestBean testBean);

    /*删除*/
    public void delete(int id);

    /*更新   改 */
    public void update(TestBean testBean);
}
