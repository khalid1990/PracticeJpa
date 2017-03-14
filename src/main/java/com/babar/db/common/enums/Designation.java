package com.babar.db.common.enums;

/**
 * @author babar
 * @since 2/23/17.
 */
public enum Designation {

    DATA_ENTRY("Data Entry Operator"),
    SUPERVISOR("Supervisor"),
    ADMIN("Administrator");

    String name;

    Designation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
