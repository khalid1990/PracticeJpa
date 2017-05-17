package com.babar.web.question.model;

import com.babar.db.entity.Institution;
import com.babar.web.common.ActionView;

import javax.validation.Valid;
import java.io.Serializable;

/**
 * @author babar
 * @since 4/24/17.
 */
public class InstitutionCommand implements Serializable{

    private static final long serialVersionUID = 1L;

    @Valid
    private Institution institution;

    private ActionView actionView;

    private String backLink;

    public InstitutionCommand() {
    }

    public InstitutionCommand(Institution institution, ActionView actionView, String backLink) {
        this.institution = institution;
        this.actionView = actionView;
        this.backLink = backLink;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public ActionView getActionView() {
        return actionView;
    }

    public void setActionView(ActionView actionView) {
        this.actionView = actionView;
    }

    public String getBackLink() {
        return backLink;
    }

    public void setBackLink(String backLink) {
        this.backLink = backLink;
    }
}
