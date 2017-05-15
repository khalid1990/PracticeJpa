package com.babar.web.question.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author babar
 * @since 5/15/17.
 */
@Controller
@RequestMapping("/common")
public class CommonController {

    private static final String COMMON_DONE_PAGE = "common-done-page";

    @RequestMapping("/done")
    public String done() {
        return COMMON_DONE_PAGE;
    }

}
