package com.benjamin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.benjamin.bean.Department;
import org.apache.ibatis.annotations.CacheNamespace;

import java.util.List;

/**
 * @CacheNamespace：开启二级缓存
 */
@CacheNamespace
public interface DepartmentDao extends BaseMapper<Department> {

    List<Department> findAllByCondition(Department department);
}
