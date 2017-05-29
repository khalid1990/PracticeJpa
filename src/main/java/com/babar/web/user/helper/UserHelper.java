package com.babar.web.user.helper;

import com.babar.db.entity.User;
import com.babar.framework.workflow.WorkflowManager;
import com.babar.web.common.Action;
import com.babar.web.common.ActionView;
import com.babar.web.common.ViewMode;
import com.babar.web.user.controller.UserController;
import com.babar.web.user.model.UserCommand;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import java.util.Arrays;

/**
 * @author babar
 * @since 5/23/17.
 */
@Component
public class UserHelper {

    public User createNewUser() {
        return new User();
    }

    public void checkAccess(User user, Action action) {

    }

    public void populateModel(User user, ModelMap modelMap, ViewMode viewMode, Action action) {
        modelMap.put(UserController.COMMAND_NAME, createUserCommand(user, viewMode, action));
    }

    private UserCommand createUserCommand(User user, ViewMode viewMode, Action action) {
        UserCommand command = new UserCommand();
        command.setUser(user);
        command.setAv(new ActionView(viewMode, Arrays.asList(action)));

        return command;
    }
}
