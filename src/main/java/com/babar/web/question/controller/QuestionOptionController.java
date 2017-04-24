package com.babar.web.question.controller;

import com.babar.web.question.helper.QuestionOptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author babar
 * @since 3/15/17.
 */
@Controller
@RequestMapping("questionOption")
public class QuestionOptionController {

    private static final String QO_FORM = "question-option-form";

    @Autowired
    private QuestionOptionHelper helper;

    @RequestMapping("/show")
    public String show() {
        return QO_FORM;
    }

    @RequestMapping("/create")
    public String create(ModelMap modelMap) {
        helper.populateModel(modelMap);

        return QO_FORM;
    }

    @RequestMapping("/edit")
    public String edit() {
        return QO_FORM;
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

    @RequestMapping(name = "index", method = RequestMethod.POST, params = "_action_return")
    public String returnToSubmitter() {
        return "done";
    }

    @RequestMapping(name = "index", method = RequestMethod.POST, params = "_action_delete")
    public String delete() {
        return "done";
    }
}
