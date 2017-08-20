package com.babar.web.user.model;

import com.babar.db.entity.User;
import com.babar.web.common.ActionView;

import javax.validation.Valid;
import java.io.Serializable;

/**
 * @author babar
 * @since 5/23/17.
 */
public class UserCommand implements Serializable{

    private static final long serialVersionUID = 1L;

    @Valid
    private User user;

    private String backLink;

    private ActionView av;

    private String oldPassword;

    private String newPassword;

    private String confirmPassword;

    public UserCommand() {
    }

    public UserCommand(User user, String backLink, ActionView av) {
        this.user = user;
        this.backLink = backLink;
        this.av = av;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBackLink() {
        return backLink;
    }

    public void setBackLink(String backLink) {
        this.backLink = backLink;
    }

    public ActionView getAv() {
        return av;
    }

    public void setAv(ActionView av) {
        this.av = av;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
