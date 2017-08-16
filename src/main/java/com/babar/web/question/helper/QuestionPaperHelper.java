package com.babar.web.question.helper;

import com.babar.common.UserContext;
import com.babar.db.common.enums.FormStatus;
import com.babar.db.entity.QuestionPaper;
import com.babar.framework.workflow.FormType;
import com.babar.framework.workflow.WorkflowManager;
import com.babar.utils.StringUtils;
import com.babar.utils.Util;
import com.babar.web.common.*;
import com.babar.web.question.controller.QuestionPaperController;
import com.babar.web.question.model.QuestionPaperCommand;
import com.babar.web.question.service.InstitutionService;
import com.babar.web.question.service.QuestionPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author babar
 * @since 3/15/17.
 */
@Component
public class QuestionPaperHelper {

    private final int RECORDS_PER_PAGE = 2;

    @Autowired
    private QuestionPaperService questionPaperService;

    public QuestionPaper createQuestionPaper() {
        QuestionPaper questionPaper = new QuestionPaper();
        questionPaper.setStatus(FormStatus.NEW);

        return questionPaper;
    }

    public void checkAccess(QuestionPaper questionPaper, Action action) {

    }

    public void populateModel(QuestionPaper questionPaper,
                              ModelMap modelMap,
                              ViewMode viewMode) {

        modelMap.addAttribute(QuestionPaperController.COMMAND_NAME, createNewCommand(questionPaper, viewMode));
    }

    public void populateModelWithListTableInfo(int currentIndex,
                                               String sortOrder,
                                               String sortProperty,
                                               ModelMap modelMap) {


        modelMap.put("currentIndex", currentIndex);
        modelMap.put("listUrl", "/qbank/questionPaper/list");
        modelMap.put("recordLoaderUrl", "/qbank/questionPaper/show");
        modelMap.put("sortOrder", sortOrder);
        modelMap.put("sortProperty", sortProperty);
        modelMap.put("currentUrl", Util.getCurrentUrl());

        int startIndex = currentIndex * RECORDS_PER_PAGE;
        List<QuestionPaper> records = questionPaperService.getSortedQuestionPapers(sortProperty, sortOrder, startIndex, RECORDS_PER_PAGE);
        modelMap.put("records", records);

        int usersCount = CollectionUtils.isEmpty(records) ? 0 : records.size();
        if (usersCount < RECORDS_PER_PAGE || usersCount == 0) {
            modelMap.put("disableNextButton", true);
        }

        if (usersCount == 0) {
            modelMap.put("noResultFound", true);
        }

        Map<String, String> propertyColumnNamMap = new LinkedHashMap<>();

        propertyColumnNamMap.put("examTitle", "qp.exam.category");
        propertyColumnNamMap.put("examSerial", "qp.exam.serial");
        propertyColumnNamMap.put("examDate", "qp.exam.date");
        propertyColumnNamMap.put("institution", "label.institution");
        propertyColumnNamMap.put("examCategory", "qp.exam.category");

        modelMap.put("propertyColumnNameMap", propertyColumnNamMap);
    }

    private QuestionPaperCommand createNewCommand(QuestionPaper questionPaper, ViewMode viewMode) {
        QuestionPaperCommand command = new QuestionPaperCommand();
        command.setQuestionPaper(questionPaper);
        ActionView actionView = WorkflowManager.getActionView(FormType.FT_QUESTION_PAPER, questionPaper.getStatus(), viewMode, UserContext.getProfileRoles());
        command.setActionView(actionView);
        command.setBackLink(Util.getBackLink());

        return command;
    }

    public String getShowPageUrl(int id, String backLink) {
        UrlGenerator ug = new UrlGenerator(Url.QUESTION_PAPER_SHOW);
        return ug.addParam("id", String.valueOf(id))
                 .addParam("backLink", backLink).getRawUrl();
    }
}
