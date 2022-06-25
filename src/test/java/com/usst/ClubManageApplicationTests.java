package com.usst;

import com.usst.service.BelongService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClubManageApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    private BelongService belongService;
    @Test
    void belong(){
        System.out.println(belongService.getClubBelong(1));
    }

}
