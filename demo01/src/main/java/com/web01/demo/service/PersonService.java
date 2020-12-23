package com.web01.demo.service;

import com.web01.demo.pojo.Person;

public interface PersonService {
    public int deletePerson(Integer pid);
    public Person selectById(Integer pid);
}
