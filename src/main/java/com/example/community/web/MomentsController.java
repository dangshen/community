package com.example.community.web;

import com.example.community.domain.Favorite;
import com.example.community.domain.Moments;
import com.example.community.domain.User;
import com.example.community.service.FavoriteService;
import com.example.community.service.MomentsService;
import com.example.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;

@Controller
@RequestMapping("/moments")
public class MomentsController {
    @Autowired
    private MomentsService momentsService;
    @Autowired
    private UserService userService;
    @Autowired
    private FavoriteService favoriteService;

    //发布朋友圈
    @RequestMapping("/publishMoments")
    @ResponseBody
    public Map<String, Object> publishMoments(@ModelAttribute Moments moments, @RequestParam Integer uId) {
        System.out.println("uid: " + uId);
        Map<String, Object> returnMap = new HashMap<>();
        moments.setmTime(new Timestamp(System.currentTimeMillis()));
        moments.setUser(userService.findUserById(uId));
        try {
            int result = momentsService.publishMoments(moments);
            if (result == 1) {
                returnMap.put("result", "发布成功");
                returnMap.put("moments", moments);
            } else {
                returnMap.put("result", "发布失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnMap.put("result", "发布失败");
        }
        return returnMap;
    }

    //删除朋友圈
    //bug:判断moments与user是否对应
    @RequestMapping("/deleteMoments")
    @ResponseBody
    public Map<String, Object> deleteMoments(@ModelAttribute Moments moments) {
        Map<String, Object> returnMap = new HashMap<>();
        try {
            //删除点赞关系
            //没有点赞关系返回0; 成功删除返回1
            int resultDeleteFavrorite = favoriteService.removeAllFatoriteByMoments(moments.getmId());
            System.out.println("resultDeleteFavrorite：" + resultDeleteFavrorite);
            //删除朋友圈
            int resultDeleteMoments = momentsService.removeMoments(moments);
            System.out.println("resultDeleteMoments：" + resultDeleteMoments);

            if (resultDeleteMoments == 1 && (resultDeleteFavrorite == 1 || resultDeleteFavrorite == 0)) {
                returnMap.put("result", "删除成功");
            } else {
                returnMap.put("result", "删除失败");
            }
        } catch (Exception e) {
            returnMap.put("result", "删除失败");
        }
        return returnMap;
    }

    //朋友圈点赞
    @RequestMapping("/likeMoments")
    @ResponseBody
    public Map<String, Object> likeMoments(@RequestParam Integer uId, @RequestParam Integer mId) {
        Map<String, Object> returnMap = new HashMap<>();
        try {
            int result = momentsService.likeMoments(uId, mId);
            if (result == 1) {
                returnMap.put("result", "点赞成功");
            } else {
                returnMap.put("result", "点赞失败");
            }
        } catch (Exception e) {
            returnMap.put("result", "点赞失败");
        }
        return returnMap;
    }

    //取消点赞
    @RequestMapping("/unlikeMoments")
    @ResponseBody
    public Map<String, Object> unlikeMoments(@RequestParam Integer uId, @RequestParam Integer mId) {
        Map<String, Object> returnMap = new HashMap<>();
        try {
            int result = momentsService.unLikeMoments(uId, mId);
            if (result == 1) {
                returnMap.put("result", "取消点赞成功");
            } else {
                returnMap.put("result", "取消点赞失败");
            }
        } catch (Exception e) {
            returnMap.put("result", "取消点赞失败");
        }
        return returnMap;
    }

    @RequestMapping("/showMoments")
    @ResponseBody
    public Map<String, Object> showMoments() {
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("momentsList", momentsService.getAllMoments());
        return returnMap;
    }
}
