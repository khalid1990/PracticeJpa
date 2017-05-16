package com.babar.web.question.controller;

import com.babar.db.entity.QuestionPaper;
import com.babar.web.common.Forwards;
import com.babar.web.question.helper.QuestionPaperHelper;
import com.babar.web.question.model.QuestionPaperCommand;
import com.babar.web.question.service.QuestionPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.support.AbstractMultipartHttpServletRequest;

import javax.validation.Valid;

import static com.babar.web.common.ViewMode.*;
import static com.babar.web.common.Action.*;

/**
 * @author babar
 * @since 3/15/17.
 */
@Controller
@RequestMapping("questionPaper")
public class QuestionPaperController {

    private static final String QP_FORM = "qpForm";

    public static final String COMMAND_NAME = "command";

    @Autowired
    private QuestionPaperHelper helper;

    @Autowired
    private QuestionPaperService questionPaperService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(ModelMap modelMap) {
        QuestionPaper questionPaper = helper.createQuestionPaper();

        helper.checkAccess(questionPaper, SAVE);

        helper.populateModel(questionPaper, modelMap, EDITABLE, SAVE);

        return QP_FORM;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show(@RequestParam("id") int id,
                       ModelMap modelMap) {

        QuestionPaper questionPaper = questionPaperService.find(id);

        helper.checkAccess(questionPaper, SUBMIT);
        helper.populateModel(questionPaper, modelMap, READ_ONLY, SUBMIT);

        return QP_FORM;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam("id") int id,
                       ModelMap modelMap) {

        QuestionPaper questionPaper = questionPaperService.find(id);

        helper.checkAccess(questionPaper, UPDATE);
        helper.populateModel(questionPaper, modelMap, EDITABLE, UPDATE);

        return QP_FORM;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_save")
    public String save(@ModelAttribute(COMMAND_NAME) @Valid QuestionPaperCommand command,
                       BindingResult bindingResult,
                       ModelMap modelMap) {

        if (bindingResult.hasErrors()) {
            helper.populateModelWithInstitutions(modelMap);
            return QP_FORM;
        }

        return "redirect:" + Forwards.COMMON_DONE;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_update")
    public String update(@ModelAttribute(COMMAND_NAME) @Valid QuestionPaperCommand command,
                         BindingResult bindingResult,
                         ModelMap modelMap) {

        if (bindingResult.hasErrors()) {
            helper.populateModelWithInstitutions(modelMap);
            return QP_FORM;
        }

        return "redirect:" + Forwards.COMMON_DONE;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_submit")
    public String submit(@ModelAttribute(COMMAND_NAME) QuestionPaperCommand command) {
        return "redirect:" + Forwards.COMMON_DONE;
    }


    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_approve")
    public String approve(@ModelAttribute(COMMAND_NAME) @Valid QuestionPaperCommand  command,
                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return QP_FORM;
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
