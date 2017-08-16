package com.babar.web.common;

/*
* Note: Important lesson learned; when I was generating the url to which my request was being
* redirected, I accidentally used '//' in the path instead of '/'; (like : /qbank//question/show)
* which didn't have any visible effect on the request processing but there was a catch;
* my redirect flash attribute was not working and I almost wasted 2/3 hours behind this. :( .
* */

/**
 * @author babar
 * @since 8/9/17.
 */

 public enum Url {
    QUESTION_PAPER_SHOW("questionPaper/show"),
    QUESTION_PAPER_EDIT("questionPaper/edit"),
    QUESTION_SHOW("question/show"),
    QUESTION_EDIT("question/edit"),
    USER_SHOW("user/show"),
    USER_EDIT("user/edit"),
    INSTITUTION_SHOW("institution/show"),
    INSTITUTION_EDIT("institution/edit")
    ;

    Url(String url) {
        this.url = url;
    }

    private String url;

    public String getUrl() {
        return "/qbank/" + url;
    }

}
