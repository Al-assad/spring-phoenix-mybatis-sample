package site.assad.sample.phoenix;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import site.assad.sample.phoenix.mapper.UserMapper;
import site.assad.sample.phoenix.po.User;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class PhoenixTest {
    
    @Resource
    private UserMapper userMapper;
    
    @Test
    public void test1(){
        List<User> users = userMapper.getAll();
        users.forEach(System.out::println);
    }
    
    @Test
    public void test2(){
        User user = userMapper.getUserByRowkey("key333");
        System.out.println(user);
    }
    
    @Test
    public void test3(){
        User user = new User();
        user.setRowkey("key233");
        user.setAge(44);
        user.setBirthday(Date.from(LocalDateTime.parse("1987-01-02 00:10:12", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).atZone(ZoneId.systemDefault()).toInstant()));
        user.setName("Valina");
        userMapper.addUser(user);
    }
    
    @Test
    public void test4(){
        userMapper.deleteUser("key233");
    }
    
}
