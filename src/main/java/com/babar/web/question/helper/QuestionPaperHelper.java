package com.babar.web.question.helper;

import com.babar.db.common.enums.Language;
import com.babar.db.entity.Institution;
import com.babar.db.entity.QuestionPaper;
import com.babar.db.entity.User;
import com.babar.web.common.Action;
import com.babar.web.common.ActionView;
import com.babar.web.common.ViewMode;
import com.babar.web.question.controller.QuestionPaperController;
import com.babar.web.question.model.QuestionPaperCommand;
import com.babar.web.question.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author babar
 * @since 3/15/17.
 */
@Component
public class QuestionPaperHelper {

    @Autowired
    private InstitutionService institutionService;

    public QuestionPaper createQuestionPaper() {
        return new QuestionPaper();
    }

    public void checkAccess(QuestionPaper questionPaper, Action action) {

    }

    public void populateModel(QuestionPaper questionPaper,
                              ModelMap modelMap,
                              ViewMode viewMode,
                              Action action) {

        modelMap.addAttribute(QuestionPaperController.COMMAND_NAME, createNewCommand(questionPaper, viewMode, action));
        populateModelWithInstitutions(modelMap);
    }

    public void populateModelWithInstitutions(ModelMap modelMap) {
        modelMap.addAttribute("institutions", institutionService.getAll());
    }

    private QuestionPaperCommand createNewCommand(QuestionPaper questionPaper, ViewMode viewMode, Action action) {
        return new QuestionPaperCommand(questionPaper, new ActionView(viewMode, action), getBackLink());
    }

    private String getBackLink() {
        return "";
    }
}
