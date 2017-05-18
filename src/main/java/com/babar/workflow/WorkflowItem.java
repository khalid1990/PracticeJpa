package com.babar.framework.workflow;

import com.babar.db.common.enums.FormStatus;
import com.babar.web.common.Action;

/**
 * @author babar
 * @since 3/22/17.
 */
public class WorkflowItem {

    private FormStatus fromStatus;

    private Action action;

    private FormStatus toStatus;

    public WorkflowItem(FormStatus fromStatus, Action action, FormStatus toStatus) {
        this.fromStatus = fromStatus;
        this.action = action;
        this.toStatus = toStatus;
    }

    public FormStatus getFromStatus() {
        return fromStatus;
    }

    public void setFromStatus(FormStatus fromStatus) {
        this.fromStatus = fromStatus;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public FormStatus getToStatus() {
        return toStatus;
    }

    public void setToStatus(FormStatus toStatus) {
        this.toStatus = toStatus;
    }
}
