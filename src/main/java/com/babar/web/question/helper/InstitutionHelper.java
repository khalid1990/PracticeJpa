package com.babar.web.question.helper;

import com.babar.db.entity.Institution;
import com.babar.web.common.Action;
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

    public void checkAccess(Institution institution, Action action) {

    }

    public void populateModel(ModelMap modelMap,
                              Institution institution,
                              ViewMode viewMode,
                              Action action) {

        modelMap.put("command", createNewInstitutionCommand(institution));
    }

    private InstitutionCommand createNewInstitutionCommand(Institution institution) {
        InstitutionCommand command = new InstitutionCommand();
        command.setInstitution(institution);

        return command;
    }
}
