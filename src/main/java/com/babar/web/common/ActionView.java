package com.babar.web.common;

/**
 * @author babar
 * @since 3/17/17.
 */
public class ActionView {

    private boolean canSave;

    private boolean canUpdate;

    private boolean canSubmit;

    private boolean canApprove;

    private boolean canReturn;

    private boolean canDelete;

    private ViewMode viewMode;

    private boolean readOnly;

    public ActionView(ViewMode viewMode, Action... actions) {
        this.viewMode = viewMode;
        readOnly = viewMode == ViewMode.READ_ONLY;
        populateBooleanFields(actions);
    }

    private void populateBooleanFields(Action... actions) {

        for (Action action : actions) {
            switch (action) {

                case SAVE:
                    canSave = true;
                    break;

                case UPDATE:
                    canUpdate = true;
                    break;

                case SUBMIT:
                    canSubmit = true;
                    break;

                case APPROVE:
                    canApprove = true;
                    break;

                case RETURN:
                    canReturn = true;
                    break;

                case DELETE:
                    canDelete = true;
                    break;
            }
        }
    }

    public boolean isCanSave() {
        return canSave;
    }

    public void setCanSave(boolean canSave) {
        this.canSave = canSave;
    }

    public boolean isCanUpdate() {
        return canUpdate;
    }

    public void setCanUpdate(boolean canUpdate) {
        this.canUpdate = canUpdate;
    }

    public boolean isCanSubmit() {
        return canSubmit;
    }

    public void setCanSubmit(boolean canSubmit) {
        this.canSubmit = canSubmit;
    }

    public boolean isCanApprove() {
        return canApprove;
    }

    public void setCanApprove(boolean canApprove) {
        this.canApprove = canApprove;
    }

    public boolean isCanReturn() {
        return canReturn;
    }

    public void setCanReturn(boolean canReturn) {
        this.canReturn = canReturn;
    }

    public boolean isCanDelete() {
        return canDelete;
    }

    public void setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
    }

    public ViewMode getViewMode() {
        return viewMode;
    }

    public void setViewMode(ViewMode viewMode) {
        this.viewMode = viewMode;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }
}
