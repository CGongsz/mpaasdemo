package com.nov.mpaasdemo.repository;

import com.definesys.mpaas.query.MpaasQueryFactory;
import com.nov.mpaasdemo.bean.User;
import com.nov.mpaasdemo.vo.MpaasUserView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private MpaasQueryFactory mpaasQueryFactory;

    @Test
    public void testInsert(){
        User user = new User();
        user.setCode("009");
        user.setAge(33);
        user.setBirthday(new Date());
        user.setEmail("354597202@qq.com");
        user.setDescription("cccccc");
        user.setName("yyyy");
        user.setSalary(99999.0);
        user.setCreatedBy("system");
        user.setCreationDate(new Date());
        user.setLastUpdateDate(new Date());
        user.setLastUpdatedBy("system");
        user.setObjectVersionNumber(1);

        mpaasQueryFactory.buildQuery()
                .doInsert(user);
        System.out.println(user);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setCode("009");
        user.setAge(55);
        user.setBirthday(new Date());
        user.setEmail("354597202@qq.com");
        user.setDescription("ddddd");
        user.setName("dddddd");
        user.setSalary(99999.0);
        user.setCreatedBy("system");
        user.setCreationDate(new Date());
        user.setLastUpdateDate(new Date());
        user.setLastUpdatedBy("system");
        user.setObjectVersionNumber(1);
        mpaasQueryFactory.buildQuery()
                .eq("name", "eeeeeeee")
                .doUpdate(user);

    }
}