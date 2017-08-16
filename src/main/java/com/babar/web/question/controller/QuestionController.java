package com.babar.web.question.controller;

import com.babar.db.entity.Question;
import com.babar.db.entity.QuestionPaper;
import com.babar.web.common.*;
import com.babar.web.question.helper.QuestionHelper;
import com.babar.web.question.model.QuestionCommand;
import com.babar.web.question.service.QuestionOptionService;
import com.babar.web.question.service.QuestionPaperService;
import com.babar.web.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import static com.babar.web.common.Action.*;

/**
 * @author babar
 * @since 3/14/17.
 */
@Controller
@RequestMapping("/question")
@SessionAttributes(QuestionController.COMMAND_NAME)
public class QuestionController {

    private static final String QUESTION_FORM = "question-form";

    public static final String COMMAND_NAME = "command";

    @Autowired
    private QuestionHelper helper;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionOptionService questionOptionService;

    @Autowired
    private QuestionPaperService questionPaperService;

    @Autowired
    private MessageSourceAccessor msa;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(@RequestParam("qpId") int qpId, ModelMap modelMap) {

        QuestionPaper questionPaper = questionPaperService.find(qpId);
        Question question = helper.createNewQuestion(questionPaper);
        helper.checkAccess(question, SAVE);

        helper.populateModel(modelMap, question, ViewMode.EDITABLE);

        return QUESTION_FORM;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show(@RequestParam("id") int id,
                       ModelMap modelMap){

        Question question = questionService.find(id);
        helper.checkAccess(question, VIEW);

        helper.populateModel(modelMap, question, ViewMode.READ_ONLY);

        return QUESTION_FORM;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam("id") int id,
                       ModelMap modelMap) {

        Question question = questionService.find(id);
        helper.checkAccess(question, UPDATE);

        helper.populateModel(modelMap, question, ViewMode.EDITABLE);

        return QUESTION_FORM;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_save")
    public String save(@ModelAttribute(COMMAND_NAME) @Valid QuestionCommand command,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {

        Question question = command.getQuestion();
        helper.checkAccess(question, SAVE);

        if (bindingResult.hasErrors()) {
            return QUESTION_FORM;
        }
        questionService.save(question);

        return ControllerUtils.redirectToCommon(redirectAttributes,
                                        msa.getMessage("msg.save.successful",new String[] {"Question"}),
                                        (new UrlGenerator(Url.QUESTION_SHOW)).
                                                addParam("id", String.valueOf(question.getId())).getRawUrl());
    }

    /*
    * Note: Important lesson learned; when I was generating the url to which my request was being
    * redirected, I accidentally used '//' in the path instead of '/'; (like : /qbank//question/show)
    * which didn't have any visible effect on the request processing but there was a catch;
    * my redirect flash attribute was not working and I almost wasted 2/3 hours behind this. :( .
    * */
    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_update")
    public String update(@ModelAttribute(COMMAND_NAME) @Valid QuestionCommand command,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {

        Question question = command.getQuestion();
        helper.checkAccess(question, UPDATE);

        if (bindingResult.hasErrors()) {
            return QUESTION_FORM;
        }
        questionService.update(question);

        return ControllerUtils.redirectWithMessage(redirectAttributes,
                msa.getMessage("msg.update.successful", new String[]{"Question"}),
                (new UrlGenerator(Url.QUESTION_SHOW)).
                        addParam("id", String.valueOf(question.getId())).getRawUrl());
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_submit")
    public String submit(@ModelAttribute(COMMAND_NAME) @Valid QuestionCommand command,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {

        Question question = command.getQuestion();
        helper.checkAccess(question, SUBMIT);

        if (bindingResult.hasErrors()) {
            return QUESTION_FORM;
        }
        questionService.submit(question);

        return ControllerUtils.redirectWithMessage(redirectAttributes,
                msa.getMessage("msg.submit.successful", new String[]{"Question"}),
                (new UrlGenerator(Url.QUESTION_SHOW)).
                        addParam("id", String.valueOf(question.getId())).getRawUrl());
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_approve")
    public String approve(@ModelAttribute(COMMAND_NAME) @Valid QuestionCommand command,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {

        Question question = command.getQuestion();
        helper.checkAccess(question, APPROVE);

        if (bindingResult.hasErrors()) {
            return QUESTION_FORM;
        }
        questionService.approve(question);

        return ControllerUtils.redirectWithMessage(redirectAttributes,
                msa.getMessage("msg.approve.successful", new String[]{"Question"}),
                (new UrlGenerator(Url.QUESTION_SHOW)).
                        addParam("id", String.valueOf(question.getId())).getRawUrl());
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_return")
    public String returnToSubmitter(@ModelAttribute(COMMAND_NAME) @Valid QuestionCommand command,
                                    BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        Question question = command.getQuestion();
        helper.checkAccess(question, RETURN);

        if (bindingResult.hasErrors()) {
            return QUESTION_FORM;
        }

        questionService.returnToSubmitter(question);

        return ControllerUtils.redirectWithMessage(redirectAttributes,
                msa.getMessage("msg.return.successful", new String[]{"Question"}),
                (new UrlGenerator(Url.QUESTION_SHOW)).
                        addParam("id", String.valueOf(question.getId())).getRawUrl());
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_delete")
    public String delete(@ModelAttribute(COMMAND_NAME) @Valid QuestionCommand command,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        Question question = command.getQuestion();
        helper.checkAccess(question, DELETE);

        if (bindingResult.hasErrors()) {
            return QUESTION_FORM;
        }

        questionService.delete(question);

        return ControllerUtils.redirectWithMessage(redirectAttributes,
                msa.getMessage("msg.delete.successful", new String[]{"Question"}),
                (new UrlGenerator(Url.QUESTION_SHOW)).
                        addParam("id", String.valueOf(question.getId())).getRawUrl());
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_back")
    public String back(@ModelAttribute(COMMAND_NAME) QuestionCommand command,
                       SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return ControllerUtils.redirect(command.getBackLink());
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_back_show")
    public String backToShow(@ModelAttribute(COMMAND_NAME) QuestionCommand command,
                             SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return ControllerUtils.redirect(helper.getShowPageUrl(command.getQuestion().getId(), command.getBackLink()));
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_cancel")
    public String cancel(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return ControllerUtils.redirectToDashboard();
    }
}
