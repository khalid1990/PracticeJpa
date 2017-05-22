package com.babar.web.question.helper;

import com.babar.db.common.enums.FormStatus;
import com.babar.db.entity.Institution;
import com.babar.framework.workflow.FormType;
import com.babar.framework.workflow.WorkflowManager;
import com.babar.web.common.Action;
import com.babar.web.common.ActionView;
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
        Institution institution = new Institution();

        return institution;
    }

    public void checkAccess(Institution institution, Action action) {

    }

    public void populateModel(ModelMap modelMap,
                              Institution institution,
                              ViewMode viewMode,
                              Action action) {

        modelMap.put("command", createNewInstitutionCommand(institution, viewMode));
    }

    private InstitutionCommand createNewInstitutionCommand(Institution institution, ViewMode viewMode) {
        InstitutionCommand command = new InstitutionCommand();
        command.setInstitution(institution);
        //Roles roles =
        ActionView actionView = WorkflowManager.getActionView(FormType.FT_INSTITUTION, institution.getStatus(), viewMode);
        command.setActionView(actionView);

        return command;
    }
}
