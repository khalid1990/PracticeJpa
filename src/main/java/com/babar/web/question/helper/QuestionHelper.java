package com.babar.web.question.helper;

import com.babar.common.UserContext;
import com.babar.db.common.enums.ExamCategory;
import com.babar.db.common.enums.ExamSubCategory;
import com.babar.db.common.enums.FormStatus;
import com.babar.db.entity.Question;
import com.babar.db.entity.QuestionOption;
import com.babar.db.entity.QuestionPaper;
import com.babar.framework.workflow.FormType;
import com.babar.framework.workflow.WorkflowManager;
import com.babar.web.common.Action;
import com.babar.web.common.ActionView;
import com.babar.web.common.ViewMode;
import com.babar.web.question.controller.QuestionController;
import com.babar.web.question.model.QuestionCommand;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author babar
 * @since 3/15/17.
 */
@Component
public class QuestionHelper {

    public Question createNewQuestion(QuestionPaper questionPaper) {
        Question question = new Question();
        question.setQuestionPaper(questionPaper);
        question.setStatus(FormStatus.NEW);

        return question;
    }

    public void checkAccess(Question question, Action action) {

    }

    public void populateModel(ModelMap modelMap,
                              Question question,
                              ViewMode viewMode) {

        modelMap.put(QuestionController.COMMAND_NAME, createQuestionCommand(question, viewMode));
    }

    private QuestionCommand createQuestionCommand(Question question, ViewMode viewMode) {

        QuestionCommand command = new QuestionCommand();

        if (CollectionUtils.isEmpty(question.getQuestionOptions())) {
            question.setQuestionOptions(Arrays.asList(new QuestionOption[question.getTotalOptions()]));
        }

        command.setQuestion(question);

        ActionView actionView = WorkflowManager.getActionView(FormType.FT_QUESTION, question.getStatus(), viewMode, UserContext.getProfileRoles());
        command.setActionView(actionView);

        return command;
    }
}
