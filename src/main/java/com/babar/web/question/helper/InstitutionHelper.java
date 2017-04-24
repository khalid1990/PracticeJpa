package com.babar.web.question.helper;

import com.babar.web.question.model.InstitutionCommand;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

/**
 * @author babar
 * @since 4/24/17.
 */
@Component
public class InstitutionHelper {
    public void populateModel(ModelMap modelMap) {
        modelMap.put("command", createNewInstitutionCommand());
    }

    private InstitutionCommand createNewInstitutionCommand() {
        return new InstitutionCommand();
    }
}
