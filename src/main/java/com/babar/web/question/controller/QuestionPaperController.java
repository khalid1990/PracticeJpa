package com.babar.web.question.controller;

import com.babar.db.common.editors.InstitutionEditor;
import com.babar.db.entity.Institution;
import com.babar.db.entity.QuestionPaper;
import com.babar.web.common.ControllerUtils;
import com.babar.web.common.Forwards;
import com.babar.web.question.helper.QuestionPaperHelper;
import com.babar.web.question.model.QuestionPaperCommand;
import com.babar.web.question.service.InstitutionService;
import com.babar.web.question.service.QuestionPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.babar.web.common.Action.*;
import static com.babar.web.common.ViewMode.EDITABLE;
import static com.babar.web.common.ViewMode.READ_ONLY;

/**
 * @author babar
 * @since 3/15/17.
 */
@Controller
@RequestMapping("questionPaper")
@SessionAttributes(QuestionPaperController.COMMAND_NAME)
public class QuestionPaperController {

    private static final String QP_FORM = "qpForm";

    public static final String COMMAND_NAME = "command";

    public static final String QP_LIST_VEW = "qpListView";

    @Autowired
    private QuestionPaperHelper helper;

    @Autowired
    private QuestionPaperService questionPaperService;

    @Autowired
    private InstitutionService institutionService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true)); /* Converts empty string into null while binding */
        binder.registerCustomEditor(Institution.class, new InstitutionEditor(institutionService));
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("MM/dd/yyyy"), true));
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(ModelMap modelMap) {
        QuestionPaper questionPaper = helper.createQuestionPaper();

        helper.checkAccess(questionPaper, SAVE);

        modelMap.addAttribute("institutions", institutionService.findAll());
        helper.populateModel(questionPaper, modelMap, EDITABLE);

        return QP_FORM;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show(@RequestParam("id") int id,
                       ModelMap modelMap) {

        QuestionPaper questionPaper = questionPaperService.find(id);

        helper.checkAccess(questionPaper, VIEW);

        modelMap.addAttribute("institutions", institutionService.findAll());
        helper.populateModel(questionPaper, modelMap, READ_ONLY);

        return QP_FORM;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam("id") int id,
                       ModelMap modelMap) {

        QuestionPaper questionPaper = questionPaperService.find(id);

        helper.checkAccess(questionPaper, UPDATE);

        modelMap.addAttribute("institutions", institutionService.findAll());
        helper.populateModel(questionPaper, modelMap, EDITABLE);

        return QP_FORM;
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(@RequestParam(value = "currentIndex", required = false, defaultValue = "0") int currentIndex,
                       @RequestParam(value = "sortProperty", required = false) String sortProperty,
                       @RequestParam(value = "sortOrder", required = false) String sortOrder,
                       ModelMap modelMap) {

        helper.populateModelWithListTableInfo(currentIndex, sortOrder, sortProperty, modelMap);

        return QP_LIST_VEW;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_save")
    public String save(@ModelAttribute(COMMAND_NAME) @Valid QuestionPaperCommand command,
                       BindingResult bindingResult,
                       ModelMap modelMap) {

        QuestionPaper questionPaper = command.getQuestionPaper();
        if (bindingResult.hasErrors()) {
            return QP_FORM;
        }
        questionPaperService.save(questionPaper);

        return "redirect:" + Forwards.COMMON_DONE;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_update")
    public String update(@ModelAttribute(COMMAND_NAME) @Valid QuestionPaperCommand command,
                         BindingResult bindingResult,
                         ModelMap modelMap) {

        QuestionPaper questionPaper = command.getQuestionPaper();
        if (bindingResult.hasErrors()) {
            return QP_FORM;
        }
        questionPaperService.update(questionPaper);

        return "redirect:" + Forwards.COMMON_DONE;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_submit")
    public String submit(@ModelAttribute(COMMAND_NAME) @Valid QuestionPaperCommand command,
                         BindingResult bindingResult) {

        QuestionPaper questionPaper = command.getQuestionPaper();
        if (bindingResult.hasErrors()) {
            return QP_FORM;
        }
        questionPaperService.submit(questionPaper);

        return "redirect:" + Forwards.COMMON_DONE;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_approve")
    public String approve(@ModelAttribute(COMMAND_NAME) @Valid QuestionPaperCommand command,
                          BindingResult bindingResult) {
        QuestionPaper questionPaper = command.getQuestionPaper();

        if (bindingResult.hasErrors()) {
            return QP_FORM;
        }
        questionPaperService.approve(questionPaper);

        return "redirect:" + Forwards.COMMON_DONE;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_delete")
    public String delete(@ModelAttribute(COMMAND_NAME) @Valid QuestionPaperCommand command,
                         BindingResult bindingResult) {
        QuestionPaper questionPaper = command.getQuestionPaper();
        if (bindingResult.hasErrors()) {
            return QP_FORM;
        }
        questionPaperService.delete(questionPaper);

        return "redirect:" + Forwards.COMMON_DONE;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_return")
    public String returnToSubmitter(@ModelAttribute(COMMAND_NAME) QuestionPaperCommand command,
                                    BindingResult bindingResult) {
        QuestionPaper questionPaper = command.getQuestionPaper();
        if (bindingResult.hasErrors()) {
            return QP_FORM;
        }
        questionPaperService.returnToSubmitter(questionPaper);

        return "redirect:" + Forwards.COMMON_DONE;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_back")
    public String back(@ModelAttribute(COMMAND_NAME) QuestionPaperCommand command,
                       SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return ControllerUtils.redirect(command.getBackLink());
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_back_show")
    public String backToShow(@ModelAttribute(COMMAND_NAME) QuestionPaperCommand command,
                             SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return ControllerUtils.redirect(helper.getShowPageUrl(command.getQuestionPaper().getId(), command.getBackLink()));
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_cancel")
    public String cancel(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return ControllerUtils.redirectToDashboard();
    }
}
