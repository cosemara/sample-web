package com.sample.web.sampleweb.controller.pass;

import com.sample.web.sampleweb.service.pass.Pass;
import com.sample.web.sampleweb.service.pass.PassService;
import com.sample.web.sampleweb.service.user.User;
import com.sample.web.sampleweb.service.user.UserService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/passes")
public class PassViewController {
    private final UserService userService;
    private final PassService passService;

    public PassViewController(UserService userService, PassService passService) {
        this.userService = userService;
        this.passService = passService;
    }

    @GetMapping
    public ModelAndView getPasses(@RequestParam("userId") String userId) {
        ModelAndView modelAndView = new ModelAndView();

        final List<Pass> passes = passService.getPasses(userId);
        final User user = userService.getUser(userId);
        modelAndView.addObject("passes", passes);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("pass/index");

        return modelAndView;
    }

}