package com.babar.common.enums;

/**
 * @author babar
 * @since 3/12/17.
 */
public enum FormStatus {
    NEW(0, "New"),
    DRAFT(1, "Draft"),
    PENDING_APPROVAL(2, "Pending Approval"),
    APPROVED(3, "Approved"),
    PENDING_UPDATE_APPROVAL(4, "Pending Update Approval"),
    RETURNED(5, "Returned"),
    DELETED(6, "Deleted");

    int id;

    String value;

    FormStatus(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
