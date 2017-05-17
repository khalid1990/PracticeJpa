package com.babar.web.question.helper;

import com.babar.db.common.enums.ExamCategory;
import com.babar.db.common.enums.ExamSubCategory;
import com.babar.db.entity.Question;
import com.babar.web.common.Action;
import com.babar.web.common.ViewMode;
import com.babar.web.question.model.QuestionCommand;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

/**
 * @author babar
 * @since 3/15/17.
 */
@Component
public class QuestionHelper {

    public Question createNewQuestion() {
        return new Question();
    }

    public void checkAccess(Question question, Action action) {

    }

    public void populateModel(ModelMap modelMap,
                              Question question,
                              ExamCategory examCategory,
                              ViewMode viewMode,
                              Action action) {

        modelMap.put("command", createQuestionCommand(question));
        populateModelWithSubCategories(modelMap, examCategory);
    }

    public void populateModelWithSubCategories(ModelMap modelMap, ExamCategory examCategory) {
        modelMap.put("subCategories", ExamSubCategory.getSubCategories(examCategory));
    }

    private QuestionCommand createQuestionCommand(Question question) {

        QuestionCommand command = new QuestionCommand();
        command.setQuestion(question);

        return command;
    }
}
