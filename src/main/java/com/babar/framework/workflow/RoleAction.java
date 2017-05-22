package com.babar.framework.workflow;

import com.babar.db.common.enums.FormStatus;
import com.babar.security.Role;
import com.babar.web.common.Action;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author babar
 * @since 3/23/17.
 */
public class RoleAction {

    private Role role;

    private List<FormStatus> formStatusList;

    private List<RoleActionItem> items;

    private RoleAction(Role role) {
        this.role = role;
        formStatusList = new ArrayList<>();
        items = new ArrayList<>();
    }

    public static RoleAction with(Role role) {
        return new RoleAction(role);
    }

    public RoleAction in(FormStatus... formStatuses) {

        if (role == null) {
            throw new IllegalStateException("Illegal state");
        }

        Collections.addAll(formStatusList, formStatuses);
        return this;
    }

    public RoleAction can(Action... actions) {
        if (CollectionUtils.isEmpty(formStatusList)) {
            throw new IllegalStateException("Illegal state");
        }

        for (Action action : actions) {
            for (FormStatus status : formStatusList) {
                items.add(new RoleActionItem(role, status, action));
            }
        }
        formStatusList.clear();

        return this;
    }

    public List<RoleActionItem> getItems() {
        return items;
    }

    public void setItems(List<RoleActionItem> items) {
        this.items = items;
    }
}
