package com.babar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author babar
 * @since 3/8/17.
 */
@Entity
public class Institution {

    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    private String institutionName;

    public Institution() {
    }

    public Institution(String institutionName) {
        this.institutionName = institutionName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }
}
