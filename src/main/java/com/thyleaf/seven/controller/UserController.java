package com.thyleaf.seven.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.thyleaf.seven.domain.User;
import com.thyleaf.seven.resporister.UserResposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;

/**
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserResposity userResposity;

    @GetMapping
    public ModelAndView list(Model model){
        model.addAttribute("userList", userResposity.getUsers());
        model.addAttribute("title","用户管理");
        System.out.println(model);
        return new ModelAndView("users/list","userModel",model);

    }

    /**
     * 根据id,查询用户
     * @param id
     * @param model
     * @return
     */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model){
        User user = userResposity.getUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("title","查看用户");
        return new ModelAndView("users/view","userModel",model);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id){
        userResposity.deleteUser(id);
        return new ModelAndView("redirect:/users");
    }

    /**
     * 获取修改用户界面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/modify/{id}")
    public ModelAndView modify(@PathVariable("id") Long id,Model model){
        User user = userResposity.getUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("title","修改用户");
        return new ModelAndView("users/form","userModel",model);
    }

    /**
     * 获取创建用户表单界面
     * @param model
     * @return
     */
    @GetMapping("/form")
    public ModelAndView createForm(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("title","创建用户");
        return new ModelAndView("users/form","userModel",model);
    }

    /**
     * 保存和修改用户
     * @param user
     * @return
     */
    @PostMapping
    public ModelAndView saveOrUpdateUser(User user){
        userResposity.saveOrUpdateUser(user);
        return new ModelAndView("redirect:/users");
    }
}
