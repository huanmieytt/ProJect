package com.web01.demo.service.impl;

import com.web01.demo.mapper.PersonMapper;
import com.web01.demo.pojo.Person;
import com.web01.demo.service.PersonService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    public PersonMapper personMapper;
    @Override
    public int deletePerson(Integer pid) {
        return personMapper.deletePerson(pid);
    }

    @Override
    public Person selectById(Integer pid) {
        return personMapper.selectById(pid);
    }
}
