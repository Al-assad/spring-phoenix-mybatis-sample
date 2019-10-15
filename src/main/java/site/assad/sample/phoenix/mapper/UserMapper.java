package site.assad.sample.phoenix.mapper;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import site.assad.sample.phoenix.po.User;

import java.util.List;

public interface UserMapper {
    
    @Select("select * from user" )
    List<User> getAll();
    
    @Select("select * from user where rowkey = #{rowkey}")
    User getUserByRowkey(String rowkey);
    
    @Insert("upsert into user(rowkey, name, age, birthday) values (#{rowkey}, #{name}, #{age}, #{birthday})")
    void addUser(User user);
    
    @Delete("delete from user where rowkey = #{rowkey}")
    void deleteUser(String rowkey);
    
    
}
