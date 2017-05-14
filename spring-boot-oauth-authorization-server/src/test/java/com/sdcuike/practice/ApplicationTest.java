package com.sdcuike.practice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Test
    public void test() {
        BCryptPasswordEncoder pw = new BCryptPasswordEncoder();
        String system = pw.encode("user");
        System.out.println(system);
    }
    
}
