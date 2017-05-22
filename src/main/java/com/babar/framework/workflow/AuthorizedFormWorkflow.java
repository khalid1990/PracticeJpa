package com.babar.framework.workflow;

import com.babar.db.common.enums.FormStatus;
import com.babar.security.Role;
import com.babar.web.common.Action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author babar
 * @since 3/22/17.
 */
public class AuthorizedFormWorkflow {

    private FormWorkflow formWorkflow;

    private List<RoleActionItem> items;

    public AuthorizedFormWorkflow(FormWorkflow formWorkflow, RoleAction... roleActions) {
        this.formWorkflow = formWorkflow;
        this.items = new ArrayList<>();

        for (RoleAction roleAction : roleActions) {
            items.addAll(roleAction.getItems());
        }
    }

    public FormWorkflow getFormWorkflow() {
        return formWorkflow;
    }

    public void setFormWorkflow(FormWorkflow formWorkflow) {
        this.formWorkflow = formWorkflow;
    }

    public List<RoleActionItem> getItems() {
        return items;
    }

    public void setItems(List<RoleActionItem> items) {
        this.items = items;
    }

    public FormStatus getNextStatus(FormStatus status, Action action) {
        return formWorkflow.getToStatus(status, action);
    }

    public List<Action> getAllowedActions(FormStatus currentStatus, List<Role> roles) {

        List<Action> allowedActions = new ArrayList<>();

        for (RoleActionItem item : items) {
            if (roles.contains(item.getRole()) && currentStatus == item.getStatus()) {
                allowedActions.add(item.getAction());
            }
        }

        return allowedActions;
    }
}
