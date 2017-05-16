package com.babar.web.question.controller;

import com.babar.db.entity.Question;
import com.babar.web.common.Forwards;
import com.babar.web.common.ViewMode;
import com.babar.web.question.helper.QuestionHelper;
import com.babar.web.question.model.QuestionCommand;
import com.babar.web.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * @author babar
 * @since 3/14/17.
 */
@Controller
@RequestMapping("/question")
public class QuestionController {

    private static final String QUESTION_FORM = "question-form";

    public static final String COMMAND_NAME = "command";

    @Autowired
    private QuestionHelper helper;

    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(ModelMap modelMap) {

        Question question = helper.createNewQuestion();
        helper.populateModel(modelMap, question, ViewMode.EDITABLE);

        return QUESTION_FORM;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show(@RequestParam("id") int id,
                       ModelMap modelMap){

        Question question = questionService.find(id);
        helper.populateModel(modelMap, question, ViewMode.READ_ONLY);

        return QUESTION_FORM;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam("id") int id,
                       ModelMap modelMap) {

        Question question = questionService.find(id);
        helper.populateModel(modelMap, question, ViewMode.EDITABLE);

        return QUESTION_FORM;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_save")
    public String save(@ModelAttribute(COMMAND_NAME) @Valid QuestionCommand command,
                       BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return QUESTION_FORM;
        }

        return "redirect:" + Forwards.COMMON_DONE;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_update")
    public String update(@ModelAttribute(COMMAND_NAME) @Valid QuestionCommand command,
                         BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return QUESTION_FORM;
        }

        return "redirect:" + Forwards.COMMON_DONE;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_approve")
    public String approve(@ModelAttribute(COMMAND_NAME) @Valid QuestionCommand command,
                          BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return QUESTION_FORM;
        }

        return "redirect:" + Forwards.COMMON_DONE;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_delete")
    public String delete() {
        return "redirect:" + Forwards.COMMON_DONE;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_return")
    public String returnToSubmitter() {
        return "redirect:" + Forwards.COMMON_DONE;
    }
}
