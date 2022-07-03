package com.usst.controller;

import com.usst.entity.ClubImg;
import com.usst.service.ClubImgService;
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
@RequestMapping("/clubImg")
public class ClubImgController {

    @Autowired
    private ClubImgService clubImgService;

    @RequestMapping("/{clubId}")
    public List<ClubImg> getClubImg(@PathVariable Integer clubId) {
        return clubImgService.getClubImg(clubId);
    }

    @RequestMapping("/add/{clubId}")
    public void addClubImg(@RequestParam(value = "file", required = false) MultipartFile file, @PathVariable Integer clubId) throws Exception {

        String name = randomSequence(16) + ".jpg";
        ClubImg clubImg = new ClubImg();
        clubImg.setClubId(clubId);
        clubImg.setPath("img/club/" + name);
        clubImgService.addClubImg(clubImg);
        InputStream in = file.getInputStream();

        String path = System.getProperty("user.dir") + "/img/headImg/";
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

    @RequestMapping("/dele/{id}")
    public Integer deleClubImg(Integer id){
        return clubImgService.deleClubImg(id);
    }



}
