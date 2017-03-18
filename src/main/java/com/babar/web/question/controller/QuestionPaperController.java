package com.babar.web.question.controller;

import com.babar.db.entity.QuestionPaper;
import com.babar.web.question.helper.QuestionPaperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.support.AbstractMultipartHttpServletRequest;

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

    @RequestMapping("/show")
    public String show() {
        return QP_FORM;
    }

    @RequestMapping("/create")
    public String create(Model model) {
        QuestionPaper questionPaper = helper.createQuestionPaper();

        helper.checkAccess(questionPaper, SAVE);

        helper.populateModel(questionPaper, model, EDITABLE, SAVE);

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

    @RequestMapping(name = "index", method = RequestMethod.POST, params = "_action_submit")
    public String submit() {
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
