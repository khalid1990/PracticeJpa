package com.babar.framework.workflow;

import com.babar.db.common.enums.FormStatus;
import com.babar.web.common.Action;

import java.util.ArrayList;
import java.util.List;

/**
 * @author babar
 * @since 3/22/17.
 */
public class FormWorkflow {

    private List<WorkflowItem> workflowItems;

    private FormStatus currentStatus;

    private Action currentAction;

    private FormWorkflow() {}

    public static FormWorkflow getFormWorkflow () {
        return new FormWorkflow();
    }

    public FormWorkflow in(FormStatus fromStatus) {
        this.currentStatus = fromStatus;
        return this;
    }

    public FormWorkflow on(Action action) {
        if (this.currentStatus == null) {
            throw new UnsupportedOperationException("This operation is not supported. Follow the in-on-to sequence");
        }
        this.currentAction = action;

        return this;
    }

    public FormWorkflow to(FormStatus toStatus) {
        if (currentStatus == null || currentAction == null) {
            throw new UnsupportedOperationException("This operation is not supported. Follow the in-on-to sequence");
        }

        if (workflowItems == null) {
            workflowItems = new ArrayList<>();
        }

        workflowItems.add(new WorkflowItem(currentStatus, currentAction, toStatus));
        this.currentAction = null;

        return this;
    }

    public FormWorkflow noAction() {
        return this;
    }

    public List<WorkflowItem> getWorkflowItems() {
        return workflowItems;
    }

    public void setWorkflowItems(List<WorkflowItem> workflowItems) {
        this.workflowItems = workflowItems;
    }

    public FormStatus getToStatus(FormStatus formStatus, Action action) {
        for (WorkflowItem item : workflowItems) {
            if (formStatus == item.getFromStatus() && action == item.getAction()) {
                return item.getToStatus();
            }
        }

        return null;
    }
}
