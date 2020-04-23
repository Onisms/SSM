package com.galaxy.service;

import com.galaxy.entity.Emp;

import java.util.List;
import java.util.Map;

public interface EmpService {

    public List<Emp> queryAllById(Emp emp, int pageNum, int pageSize);

    public Map<String, Integer> queryTotalCount(Emp emp, int pageNun, int pageSize);

    public void insert(Emp emp);

    public void delete(int[] ids);

    public Emp queryById(int id);

    public int update(Emp emp);
}
