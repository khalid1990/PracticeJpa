package com.babar.web.user.controller;

import com.babar.db.entity.User;
import com.babar.web.common.Forwards;
import com.babar.web.common.ViewMode;
import com.babar.web.user.helper.UserHelper;
import com.babar.web.user.model.UserCommand;
import com.babar.web.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.babar.web.common.Action.*;

/**
 * @author babar
 * @since 5/23/17.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    public static final String COMMAND_NAME = "command";

    private static final String USER_FORM = "userForm";

    @Autowired
    private UserHelper helper;

    @Autowired
    private UserService userService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(ModelMap modelMap) {
        User user = helper.createNewUser();

        helper.checkAccess(user, SAVE);
        helper.populateModel(user, modelMap, ViewMode.EDITABLE, SAVE);

        return USER_FORM;
    }

    @RequestMapping(value = "show", method = RequestMethod.GET)
    public String show(@RequestParam("id") int id, ModelMap modelMap) {

        User user = userService.find(id);

        helper.checkAccess(user, VIEW);
        helper.populateModel(user, modelMap, ViewMode.READ_ONLY, VIEW);

        return USER_FORM;
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(@RequestParam("id") int id, ModelMap modelMap) {

        User user = userService.find(id);

        helper.checkAccess(user, UPDATE);
        helper.populateModel(user, modelMap, ViewMode.EDITABLE, UPDATE);

        return USER_FORM;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_save")
    public String save(@ModelAttribute(COMMAND_NAME) @Valid UserCommand command,
                       BindingResult bindingResult) {

        User user = command.getUser();
        helper.checkAccess(user, SAVE);

        if (bindingResult.hasErrors()) {
            return USER_FORM;
        }

        return "redirect:" + Forwards.COMMON_DONE;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_update")
    public String update(@ModelAttribute(COMMAND_NAME) @Valid UserCommand command,
                       BindingResult bindingResult) {

        User user = command.getUser();
        helper.checkAccess(user, UPDATE);

        if (bindingResult.hasErrors()) {
            return USER_FORM;
        }

        return "redirect:" + Forwards.COMMON_DONE;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_approve")
    public String approve(@ModelAttribute(COMMAND_NAME) @Valid UserCommand command,
                         BindingResult bindingResult) {

        User user = command.getUser();
        helper.checkAccess(user, APPROVE);

        if (bindingResult.hasErrors()) {
            return USER_FORM;
        }

        return "redirect:" + Forwards.COMMON_DONE;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_delete")
    public String delete(@ModelAttribute(COMMAND_NAME) @Valid UserCommand command,
                          BindingResult bindingResult) {

        User user = command.getUser();
        helper.checkAccess(user, DELETE);

        if (bindingResult.hasErrors()) {
            return USER_FORM;
        }

        return "redirect:" + Forwards.COMMON_DONE;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_return")
    public String returnToSubmitter(@ModelAttribute(COMMAND_NAME) @Valid UserCommand command,
                         BindingResult bindingResult) {

        User user = command.getUser();
        helper.checkAccess(user, RETURN);

        if (bindingResult.hasErrors()) {
            return USER_FORM;
        }

        return "redirect:" + Forwards.COMMON_DONE;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_back")
    public String back() {
        return "redirect:" + Forwards.COMMON_DONE;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_cancel")
    public String cancel() {
        return "redirect:" + Forwards.COMMON_DONE;
    }
}
