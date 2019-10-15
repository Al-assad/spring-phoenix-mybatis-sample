package site.assad.sample.phoenix.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 测试数据 PO
 *
 * @author Al-assad
 * @since 2019/10/7
 */
public class User implements Serializable {
    
    private String rowkey;
    
    private String name;
    
    private Integer age;
    
    private Date birthday;
    
    public String getRowkey() {
        return rowkey;
    }
    
    public void setRowkey(String rowkey) {
        this.rowkey = rowkey;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public Date getBirthday() {
        return birthday;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "rowkey='" + rowkey + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
