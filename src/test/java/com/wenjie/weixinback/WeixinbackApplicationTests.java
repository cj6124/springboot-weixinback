package com.wenjie.weixinback;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.List;

public class WeixinbackApplicationTests {

    @Test
    public void contextLoads() {
        List<String> strings = new ArrayList<>();
        strings.add("asdasd");
        strings.add("123123");
        strings.add("tyutyu");

        System.out.println(strings.get(0));
    }

}
