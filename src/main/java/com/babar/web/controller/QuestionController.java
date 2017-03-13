package com.babar.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author babar
 * @since 3/14/17.
 */
@Controller
@RequestMapping("/question")
public class QuestionController {

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }
}
