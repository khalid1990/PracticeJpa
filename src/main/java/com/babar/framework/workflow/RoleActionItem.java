package com.babar.framework.workflow;

import com.babar.db.common.enums.FormStatus;
import com.babar.security.Role;
import com.babar.web.common.Action;

/**
 * @author babar
 * @since 3/25/17.
 */
public class RoleActionItem {

    private Role role;

    private FormStatus status;

    private Action action;

    public RoleActionItem(Role role, FormStatus status, Action action) {
        this.role = role;
        this.status = status;
        this.action = action;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public FormStatus getStatus() {
        return status;
    }

    public void setStatus(FormStatus status) {
        this.status = status;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
