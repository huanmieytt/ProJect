package com.web01.demo.mapper;

import com.web01.demo.pojo.Person;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PersonMapper {

    @Delete("delete from person where pid = #{pid}")
    public int deletePerson(Integer pid);

    @Select("select * from person where pid = #{pid}")
    public Person selectById(Integer pid);
}
