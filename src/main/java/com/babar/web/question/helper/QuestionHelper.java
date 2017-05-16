package com.babar.web.question.helper;

import com.babar.db.common.enums.ExamCategory;
import com.babar.db.common.enums.ExamSubCategory;
import com.babar.db.entity.Question;
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

    public void populateModel(ModelMap modelMap,
                              Question question,
                              ViewMode viewMode) {

        modelMap.put("command", createQuestionCommand(question));
        modelMap.put("subCategories", ExamSubCategory.getSubCategories(ExamCategory.COMPUTER_SCIENCE_AND_ENGINEERING));
    }

    private QuestionCommand createQuestionCommand(Question question) {

        QuestionCommand command = new QuestionCommand();
        command.setQuestion(question);

        return command;
    }
}
