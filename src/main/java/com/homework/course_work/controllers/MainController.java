package com.homework.course_work.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class MainController {

    @Value("${upload.path}")
    private String pathToFile;

    @GetMapping("/all-books")
    public String books(Model model) {
        File[] files = new File(pathToFile).listFiles();

        model.addAttribute("files", files);

        return "index";
    }

    @PostMapping("/all-books")
    public String addImg(
            @RequestParam("file") MultipartFile file
    ) throws IOException {

        if (file != null) {
            File uploadFile = new File(pathToFile);

            if (!uploadFile.exists()) {
                uploadFile.mkdir();
            }

//            String uuidFile = UUID.randomUUID().toString();
//            String resultFilename = uuidFile + "." + ;

//            file.transferTo(new File(pathToFile + file.getOriginalFilename()));
//            File.createTempFile(file.getpathToFile)
//            File file1 = new File(pathToFile + file.getOriginalFilename());
        }

        return "index";
    }
}
