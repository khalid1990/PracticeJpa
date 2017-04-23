package com.babar.web.question.controller;

import com.babar.web.question.helper.QuestionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author babar
 * @since 3/14/17.
 */
@Controller
@RequestMapping("/question")
public class QuestionController {

    private static final String QUESTION_FORM = "question-form";

    @Autowired
    private QuestionHelper helper;

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping("/show")
    public String show(){
        return QUESTION_FORM;
    }

    @RequestMapping("/create")
    public String create(ModelMap modelMap) {
        helper.populateModel(modelMap);

        return QUESTION_FORM;
    }

    @RequestMapping("/edit")
    public String edit() {
        return QUESTION_FORM;
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
