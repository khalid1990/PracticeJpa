package com.babar.web.question.helper;

import com.babar.db.common.enums.ExamCategory;
import com.babar.db.common.enums.ExamSubCategory;
import com.babar.web.question.model.QuestionCommand;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

/**
 * @author babar
 * @since 3/15/17.
 */
@Component
public class QuestionHelper {

    public void populateModel(ModelMap modelMap) {
        modelMap.put("command", createQuestionCommand());
        modelMap.put("subCategories", ExamSubCategory.getSubCategories(ExamCategory.COMPUTER_SCIENCE_AND_ENGINEERING));
    }

    private QuestionCommand createQuestionCommand() {
        return new QuestionCommand();
    }
}
