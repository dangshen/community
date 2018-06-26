package com.example.community.web;

import com.example.community.domain.Moments;
import com.example.community.service.MomentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MomentsController {
    @Autowired
    private MomentsService momentsService;

    @RequestMapping("/showMoments")
    @ResponseBody
    public List<Moments> showMoments() {
        System.out.println();
        return momentsService.listMomentsByUserId(1);
    }
}
