package com.babar.db.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author babar
 * @since 3/8/17.
 */
@Entity
@NamedQuery(name = "findAllInstitutions", query = "SELECT inst from Institution inst")
public class Institution extends Persistence {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(max = 200)
    @Column(unique = true)
    private String institutionName;

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

    public boolean isNew() {
        return id == 0;
    }

    /*
     * LEARN: if you override the equals and hash method for an object then spring would be able to
     * identify the select value in <form:selected/> tag. It may also be useful in many other places.
     * Because when spring does some binding or configuration for us auto magically, it has no other
     * way to identify if two objects are equal.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Institution that = (Institution) o;

        if (id != that.id) return false;
        if (!institutionName.equals(that.institutionName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (institutionName != null ? institutionName.hashCode() : 0);
        /*NOTE: the null reference checking of institutionName is important here, otherwise when hibernate validator
        * is working it calls the hashCode() method and a direct "institutionName.hashCode()" throws NullPointerException
        * if you submit the form without entering the institutionName.
        * */

        return result;
    }
}
