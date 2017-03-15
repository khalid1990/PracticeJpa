package com.babar.web.question.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author babar
 * @since 3/15/17.
 */
@Controller
@RequestMapping("questionPaper")
public class QuestionPaperController {

    private static final String QP_FORM = "qpForm";

    @RequestMapping("/show")
    public String show() {
        return QP_FORM;
    }

    @RequestMapping("/create")
    public String create() {
        return QP_FORM;
    }

    @RequestMapping("/edit")
    public String edit() {
        return QP_FORM;
    }

    @RequestMapping(name = "index", method = RequestMethod.POST, params = "_action_save")
    public String save() {
        return "done";
    }

    @RequestMapping(name = "index", method = RequestMethod.POST, params = "_action_update")
    public String update() {
        return "done";
    }
    @RequestMapping(name = "index", method = RequestMethod.POST, params = "_action_approve")
    public String approve() {
        return "done";
    }
    @RequestMapping(name = "index", method = RequestMethod.POST, params = "_action_delete")
    public String delete() {
        return "done";
    }
    @RequestMapping(name = "index", method = RequestMethod.POST, params = "_action_return")
    public String returnToSubmitter() {
        return "done";
    }
}