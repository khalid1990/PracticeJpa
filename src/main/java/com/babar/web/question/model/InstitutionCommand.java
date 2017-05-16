package com.babar.web.question.model;

import com.babar.db.entity.Institution;

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

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }
}
