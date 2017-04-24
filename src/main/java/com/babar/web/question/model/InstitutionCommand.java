package com.babar.web.question.model;

import com.babar.db.entity.Institution;

/**
 * @author babar
 * @since 4/24/17.
 */
public class InstitutionCommand {

    public static long serialVersionUID = 1L;

    private Institution institution;

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }
}
