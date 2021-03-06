package tech.qijin.util4j.practice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.qijin.commons.lang.vo.PageReqVo;
import tech.qijin.util4j.practice.config.ProfileConfig;
import tech.qijin.util4j.practice.model.User;
import tech.qijin.util4j.practice.service.UserService;
import tech.qijin.commons.web.util.LogFormat;

import java.util.List;

/**
 * @author michealyang
 * @date 2018/11/23
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@RestController
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger("TEST");

    @Autowired
    private UserService userService;

    @Autowired
    private ProfileConfig.Property property;

    @GetMapping("/test1")
    public Object test1(@ModelAttribute PageReqVo pageReqVo) {
        List<User> users = userService.getUser(1);
        LOGGER.info(LogFormat.builder()
                .message("this is a test")
                .put("page", pageReqVo)
                .put("users", users)
                .build());
        return property.getHehe();
    }
}
