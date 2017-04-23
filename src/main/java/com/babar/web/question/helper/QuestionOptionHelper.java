package com.babar.web.question.helper;

import com.babar.web.question.model.QuestionOptionCommand;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

/**
 * @author babar
 * @since 3/15/17.
 */
@Component
public class QuestionOptionHelper {

    public void populateModel(ModelMap modelMap) {
        modelMap.put("command", createNewQuestionOptionCommand());
    }

    private QuestionOptionCommand createNewQuestionOptionCommand() {
        return new QuestionOptionCommand();
    }
}
