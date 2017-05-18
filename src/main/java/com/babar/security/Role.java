package com.babar.security;

/**
 * @author babar
 * @since 3/23/17.
 */
public enum Role {

    QUESTION_PAPER_CREATE(0, "Create Question Paper"),
    QUESTION_PAPER_UPDATE(1, "Update Question Paper"),
    QUESTION_PAPER_SUBMIT(2, "Submit Question Paper"),
    QUESTION_PAPER_APPROVE(3, "Approve Question Paper"),
    QUESTION_PAPER_RETURN(4, "Return Question Paper"),
    QUESTION_PAPER_DELETE(5, "Delete Question Paper"),

    QUESTION_CREATE(6, "Create Question"),
    QUESTION_UPDATE(7, "Update Question"),
    QUESTION_SUBMIT(8, "Submit Question"),
    QUESTION_APPROVE(9, "Approve Question"),
    QUESTION_RETURN(10, "Return Question"),
    QUESTION_DELETE(11, "Delete Question"),

    USER_CREATE(12, "Create User"),
    USER_UPDATE(13, "Update User"),
    USER_SUBMIT(14, "Submit User"),
    USER_APPROVE(15, "Approve User"),
    USER_RETURN(16, "Return User"),
    USER_DELETE(17, "Delete User"),

    INSTITUTION_CREATE(18, "Create Institution"),
    INSTITUTION_UPDATE(19, "Update Institution"),
    INSTITUTION_SUBMIT(20, "Submit Institution"),
    INSTITUTION_APPROVE(21, "Approve Institution"),
    INSTITUTION_RETURN(22, "Return Institution"),
    INSTITUTION_DELETE(23, "Delete Institution");

    private int id;

    private String name;

    Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
