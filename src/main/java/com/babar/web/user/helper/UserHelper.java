package com.babar.web.user.helper;

import com.babar.db.common.enums.Designation;
import com.babar.db.entity.User;
import com.babar.utils.StringUtils;
import com.babar.web.common.Action;
import com.babar.web.common.ActionView;
import com.babar.web.common.ViewMode;
import com.babar.web.user.controller.UserController;
import com.babar.web.user.model.UserCommand;
import com.babar.web.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author babar
 * @since 5/23/17.
 */
@Component
public class UserHelper {

    private final int RECORDS_PER_PAGE = 2;

    @Autowired
    private UserService userService;

    public User createNewUser() {
        User user = new User();
        user.setActive(true);

        return user;
    }

    public void checkAccess(User user, Action action) {

    }

    public void populateModel(User user, ModelMap modelMap, ViewMode viewMode, Action... actions) {
        modelMap.put(UserController.COMMAND_NAME, createUserCommand(user, viewMode, Arrays.asList(actions)));
    }

    public void populateModelWithListTableInfo(int currentIndex,
                                               String sortOrder,
                                               String sortProperty,
                                               String filterProperty,
                                               String filterValue,
                                               ModelMap modelMap) {


        modelMap.put("currentIndex", currentIndex);
        modelMap.put("listUrl", "/qbank/user/list");
        modelMap.put("sortOrder", sortOrder);
        modelMap.put("sortProperty", sortProperty);

        int startIndex = currentIndex * RECORDS_PER_PAGE;
        List<User> filteredUsers = userService.getFilteredUsers(filterProperty, filterValue,
                sortProperty, sortOrder, startIndex, RECORDS_PER_PAGE);
        modelMap.put("records", filteredUsers);

        int usersCount = CollectionUtils.isEmpty(filteredUsers) ? 0 : filteredUsers.size();
        if (usersCount < RECORDS_PER_PAGE || usersCount == 0) {
            modelMap.put("disableNextButton", true);
        }

        if (usersCount == 0) {
            modelMap.put("noResultFound", true);
        }

        if (!StringUtils.isAnyEmpty(filterProperty, filterValue)) {
            modelMap.put("filterProperty", filterProperty);
            modelMap.put("filterValue", filterValue);
        }

        Map<String, String> propertyColumnNamMap = new LinkedHashMap<>();

        propertyColumnNamMap.put("firstName", "label.first.name");
        propertyColumnNamMap.put("lastName", "label.last.name");
        propertyColumnNamMap.put("designation", "label.designation");
        propertyColumnNamMap.put("email", "label.email");
        propertyColumnNamMap.put("phone", "label.phone");

        modelMap.put("propertyColumnNameMap", propertyColumnNamMap);
    }

    private UserCommand createUserCommand(User user, ViewMode viewMode, List<Action> actions) {
        UserCommand command = new UserCommand();
        command.setUser(user);
        command.setAv(new ActionView(viewMode, actions));

        return command;
    }
}
