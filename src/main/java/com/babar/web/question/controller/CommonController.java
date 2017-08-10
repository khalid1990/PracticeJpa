package com.babar.web.question.controller;

import com.babar.web.common.DoneBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

}
