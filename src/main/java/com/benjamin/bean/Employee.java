package com.benjamin.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * Created by Ben Li.
 * Date: 2020/5/21
 */
@TableName("t_employee")
public class Employee {

    @TableId(value = "id")
    private Integer id;
    private String name;
    private String phone;
    private String identity;
    private Department department;

    public Employee() {
    }

    public Employee(Integer id, String name, String phone, String identity) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.identity = identity;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", identity='" + identity + '\'' +
                ", department=" + department +
                '}';
    }
}
