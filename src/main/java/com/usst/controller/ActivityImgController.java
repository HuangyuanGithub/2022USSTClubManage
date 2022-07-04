package com.usst.controller;


import com.usst.entity.ActivityImg;
import com.usst.service.ActivityImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import static com.usst.utils.GeneratorUtil.randomSequence;

@RestController
@RequestMapping("/activityImg")
public class ActivityImgController {

    @Autowired
    private ActivityImgService activityImgService;

    @RequestMapping("/{activityId}")
    public List<ActivityImg> getActivityImg(@PathVariable Integer activityId) {
        return activityImgService.getActivityImg(activityId);
    }

    @RequestMapping("/add/{activityId}")
    public void addActivityImg(@RequestParam(value = "file", required = false) MultipartFile file, @PathVariable Integer activityId) throws Exception {

        String name = randomSequence(16) + ".jpg";
        ActivityImg activityImg = new ActivityImg();
        activityImg.setActivityId(activityId);
        activityImg.setPath("/img/activity/" + name);
        activityImgService.addActivityImg(activityImg);
        InputStream in = file.getInputStream();

        String path = System.getProperty("user.dir") + "/src/main/resources/static/img/activity/";
        System.out.println(path);
        File mkdir = new File(path);
        if (!mkdir.exists()) {
            mkdir.mkdirs();
        }
        FileOutputStream os = new FileOutputStream(mkdir.getPath() + "/" + name);//定义输出流，将文件写入硬盘
        int len = 0;
        while ((len = in.read()) != -1) {
            os.write(len);
        }
        os.flush(); //关闭流
        in.close();
        os.close();
    }

    @RequestMapping("/delete/{id}")
    public Integer deleActivityImg(@PathVariable Integer id){
        return activityImgService.deleActivityImg(id);
    }



}