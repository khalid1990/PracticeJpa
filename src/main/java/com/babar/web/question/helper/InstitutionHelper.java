package com.babar.web.question.helper;

import com.babar.db.entity.Institution;
import com.babar.web.common.ViewMode;
import com.babar.web.question.model.InstitutionCommand;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

/**
 * @author babar
 * @since 4/24/17.
 */
@Component
public class InstitutionHelper {

    public Institution createNewInstitution() {
        return new Institution();
    }

    public void populateModel(ModelMap modelMap,
                              Institution institution,
                              ViewMode viewMode) {
        modelMap.put("command", createNewInstitutionCommand(institution));
    }

    private InstitutionCommand createNewInstitutionCommand(Institution institution) {
        InstitutionCommand command = new InstitutionCommand();
        command.setInstitution(institution);

        return command;
    }
}
