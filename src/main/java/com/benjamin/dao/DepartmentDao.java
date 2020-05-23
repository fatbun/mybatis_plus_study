package com.benjamin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.benjamin.bean.Department;

import java.util.List;

public interface DepartmentDao extends BaseMapper<Department> {

    List<Department> findAllByCondition(Department department);
}
