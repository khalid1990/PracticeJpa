package com.babar.db.common.editors;

import com.babar.db.entity.Institution;
import com.babar.web.question.service.InstitutionService;

import java.beans.PropertyEditorSupport;

/**
 * @author babar
 * @since 5/17/17.
 */
public class InstitutionEditor extends PropertyEditorSupport{

    private InstitutionService institutionService;

    public InstitutionEditor(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @Override
    public String getAsText() {
        return getValue() == null ? "0" : String.valueOf(((Institution) getValue()).getId());
    }

    @Override
    public void setAsText(String instId) throws IllegalArgumentException {
        setValue(institutionService.find(Integer.parseInt(instId)));
    }
}
