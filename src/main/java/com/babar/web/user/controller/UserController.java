package com.babar.web.user.controller;

import com.babar.db.entity.User;
import com.babar.security.Role;
import com.babar.web.common.*;
import com.babar.web.user.helper.UserHelper;
import com.babar.web.user.model.UserCommand;
import com.babar.web.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

import static com.babar.web.common.Action.*;

/**
 * @author babar
 * @since 5/23/17.
 */
@Controller
@RequestMapping("/user")
@SessionAttributes(UserController.COMMAND_NAME)
public class UserController {

    public static final String COMMAND_NAME = "command";

    private static final String USER_FORM = "userForm";

    private static final String USER_LIST_VIEW = "userListView";

    private static final String USER_ROLES = "roles";

    @Autowired
    private UserHelper helper;

    @Autowired
    private UserService userService;

    @Autowired
    private MessageSourceAccessor msa;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(ModelMap modelMap) {
        User user = helper.createNewUser();

        helper.checkAccess(user, SAVE);
        helper.populateModel(user, modelMap, ViewMode.EDITABLE, SAVE);

        return USER_FORM;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show(@RequestParam("id") int id,
                       ModelMap modelMap) {

        User user = userService.find(id);

        helper.checkAccess(user, VIEW);
        helper.populateModel(user, modelMap, ViewMode.READ_ONLY, UPDATE, DELETE);

        return USER_FORM;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam("id") int id,
                       @RequestParam(value = "changePassword", required = false) boolean changePassword,
                       ModelMap modelMap) {

        User user = userService.find(id);

        helper.checkAccess(user, UPDATE);
        helper.populateModel(user, modelMap, ViewMode.EDITABLE, UPDATE);
        modelMap.put("changePassword", changePassword);

        return USER_FORM;
    }

    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public String roles(@RequestParam(name = "userId") int userId,
                        @RequestParam(name = "role", required = false) Role role,
                        @RequestParam(name = "add", required = false) boolean add,
                        @RequestParam(name = "delete", required = false) boolean delete,
                        ModelMap modelMap) {

        User user = userService.find(userId);

        if (role != null) {
            if (add) {
                userService.addRole(user, role);
            }

            if (delete) {
                userService.deleteRole(user, role);
            }
        }

        List<Role> roles = userService.getRoles(user);
        List<Role> rolesNotAdded = new ArrayList<>();

        for (Role r : Role.values()) {
            if (!roles.contains(r)) {
                rolesNotAdded.add(r);
            }
        }
        modelMap.put("addedRoles", roles);
        modelMap.put("rolesNotAdded", rolesNotAdded);
        modelMap.put("userId", user.getId());

        return USER_ROLES;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(@RequestParam(value = "currentIndex", required = false, defaultValue = "0") int currentIndex,
                       @RequestParam(value = "sortProperty", required = false) String sortProperty,
                       @RequestParam(value = "sortOrder", required = false) String sortOrder,
                       ModelMap modelMap) {

        helper.populateModelWithListTableInfo(currentIndex, sortOrder, sortProperty, modelMap);

        return USER_LIST_VIEW;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_update_password")
    public String changePassword(@ModelAttribute(COMMAND_NAME) @Valid UserCommand command,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        User user = command.getUser();
        helper.checkAccess(user, UPDATE);

        if (bindingResult.hasErrors()) {
            return USER_FORM;
        }
        userService.update(user);

        return ControllerUtils.redirectWithMessage(redirectAttributes,
                msa.getMessage("msg.pwd.update.successful", new String[]{"User"}),
                helper.getShowPageUrl(user.getId(), command.getBackLink()));
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_save")
    public String save(@ModelAttribute(COMMAND_NAME) @Valid UserCommand command,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {

        User user = command.getUser();
        helper.checkAccess(user, SAVE);

        if (bindingResult.hasErrors()) {
            return USER_FORM;
        }
        userService.save(user);

        return ControllerUtils.redirectToCommon(redirectAttributes,
                                    msa.getMessage("msg.save.successful", new String[]{"User"}),
                                    helper.getShowPageUrl(user.getId(), command.getBackLink()));
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_update")
    public String update(@ModelAttribute(COMMAND_NAME) @Valid UserCommand command,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {

        User user = command.getUser();
        helper.checkAccess(user, UPDATE);

        if (bindingResult.hasErrors()) {
            return USER_FORM;
        }
        userService.update(user);

        return ControllerUtils.redirectWithMessage(redirectAttributes,
                                msa.getMessage("msg.update.successful", new String[]{"User"}),
                                helper.getShowPageUrl(user.getId(), command.getBackLink()));
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_delete")
    public String delete(@ModelAttribute(COMMAND_NAME) UserCommand command,
                         RedirectAttributes redirectAttributes) {

        User user = command.getUser();
        helper.checkAccess(user, DELETE);
        userService.delete(user);

        return ControllerUtils.redirectWithMessage(redirectAttributes,
                msa.getMessage("msg.delete.successful", new String[]{"User"}),
                helper.getShowPageUrl(user.getId(), command.getBackLink()));
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_back")
    public String back(@ModelAttribute(COMMAND_NAME) UserCommand command, SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return ControllerUtils.redirect(command.getBackLink());
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_back_show")
    public String backToShow(@ModelAttribute(COMMAND_NAME) UserCommand command, SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return ControllerUtils.redirect(helper.getShowPageUrl(command.getUser().getId(), command.getBackLink()));
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_cancel")
    public String cancel(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return ControllerUtils.redirectToDashboard();
    }
}
