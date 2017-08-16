package com.babar.web.question.controller;

import com.babar.web.common.DoneBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * @author babar
 * @since 5/15/17.
 */
@Controller
@RequestMapping("/common")
public class CommonController {

    private static final String COMMON_DONE_PAGE = "common-done-page";

    @RequestMapping(value = "/done", method = RequestMethod.GET)
    public String done() {
        return COMMON_DONE_PAGE;
    }

    @ResponseBody
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String home() {
        return "Dashboard";
    }
}
