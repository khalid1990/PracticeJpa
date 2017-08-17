package com.babar.web.question.helper;

import com.babar.common.UserContext;
import com.babar.db.common.enums.FormStatus;
import com.babar.db.entity.Institution;
import com.babar.framework.workflow.FormType;
import com.babar.framework.workflow.WorkflowManager;
import com.babar.utils.StringUtils;
import com.babar.utils.Util;
import com.babar.web.common.*;
import com.babar.web.question.controller.InstitutionController;
import com.babar.web.question.model.InstitutionCommand;
import com.babar.web.question.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author babar
 * @since 4/24/17.
 */
@Component
public class InstitutionHelper {

    private final int RECORDS_PER_PAGE = 2;

    @Autowired
    private InstitutionService institutionService;

    public Institution createNewInstitution() {
        Institution institution = new Institution();
        institution.setStatus(FormStatus.NEW);

        return institution;
    }

    public void checkAccess(Institution institution, Action action) {

    }

    public void populateModel(ModelMap modelMap,
                              Institution institution,
                              ViewMode viewMode) {

        modelMap.put(InstitutionController.COMMAND_NAME, createNewInstitutionCommand(institution, viewMode));
    }

    public String getShowUrl(int id, String backLink) {
        UrlGenerator ug = new UrlGenerator(Url.INSTITUTION_SHOW);
        ug.addParam("id", String.valueOf(id));

        if (StringUtils.isNotEmpty(backLink)) {
            ug.addParam("backLink", backLink);
        }

        return ug.getRawUrl();
    }

    public void populateModelWithListTableInfo(int currentIndex, String sortOrder, String sortProperty, ModelMap modelMap) {
        modelMap.put("currentIndex", currentIndex);
        modelMap.put("listUrl", "/qbank/institution/list");
        modelMap.put("recordLoaderUrl", Url.INSTITUTION_SHOW.getUrl());
        modelMap.put("sortOrder", sortOrder);
        modelMap.put("sortProperty", sortProperty);
        modelMap.put("currentUrl", Util.getCurrentUrl());

        int startIndex = currentIndex * RECORDS_PER_PAGE;
        List<Institution> records = institutionService.getSortedInstitutions(sortProperty, sortOrder, startIndex, RECORDS_PER_PAGE);
        modelMap.put("records", records);

        int usersCount = CollectionUtils.isEmpty(records) ? 0 : records.size();
        if (usersCount < RECORDS_PER_PAGE || usersCount == 0) {
            modelMap.put("disableNextButton", true);
        }

        if (usersCount == 0) {
            modelMap.put("noResultFound", true);
        }

        Map<String, String> propertyColumnNamMap = new LinkedHashMap<>();
        propertyColumnNamMap.put("institutionName", "label.institution.name");

        modelMap.put("propertyColumnNameMap", propertyColumnNamMap);
    }

    private InstitutionCommand createNewInstitutionCommand(Institution institution, ViewMode viewMode) {
        InstitutionCommand command = new InstitutionCommand();
        command.setInstitution(institution);
        ActionView actionView = WorkflowManager.getActionView(FormType.FT_INSTITUTION, institution.getStatus(),
                viewMode, UserContext.getProfileRoles());
        command.setActionView(actionView);
        command.setBackLink(Util.getBackLink());

        return command;
    }
}
