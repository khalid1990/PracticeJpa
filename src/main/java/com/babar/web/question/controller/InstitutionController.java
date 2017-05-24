package com.babar.web.question.controller;

import com.babar.db.entity.Institution;
import com.babar.web.common.Forwards;
import com.babar.web.common.ViewMode;
import com.babar.web.question.helper.InstitutionHelper;
import com.babar.web.question.model.InstitutionCommand;
import com.babar.web.question.service.InstitutionService;
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
 * @since 4/24/17.
 */
@Controller
@RequestMapping("/institution")
public class InstitutionController {

    private static final String INST_FORM = "inst-form";

    public static final String COMMAND_NAME = "command";

    @Autowired
    private InstitutionHelper helper;

    @Autowired
    private InstitutionService institutionService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        /*
        * If you don't register a StringTrimmerEditor here then all your empty textField will bind empty String to your
        * command object's properties and the @NotNull validation will fail as an empty string isn't a null value.
        * The value "true" passed here as the constructor argument for the StringTrimmerEditor" tells spring to
        * bind empty text inputs as null for a property
        * */
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(ModelMap modelMap) {

        Institution institution = helper.createNewInstitution();
        helper.checkAccess(institution, SAVE);
        helper.populateModel(modelMap, institution, ViewMode.EDITABLE, SAVE);

        return INST_FORM;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show(@RequestParam("id") int id, ModelMap modelMap){

        Institution institution = institutionService.find(id);
        helper.checkAccess(institution, VIEW);
        helper.populateModel(modelMap, institution, ViewMode.READ_ONLY, VIEW);

        return INST_FORM;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam("id") int id, ModelMap modelMap) {

        Institution institution = institutionService.find(id);
        helper.checkAccess(institution, UPDATE);
        helper.populateModel(modelMap, institution, ViewMode.EDITABLE, UPDATE);

        return INST_FORM;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_save")
    public String save(@ModelAttribute(COMMAND_NAME) @Valid InstitutionCommand command,
                       BindingResult bindingResult) {

        Institution institution = command.getInstitution();
        helper.checkAccess(institution, SAVE);

        if (bindingResult.hasErrors()) {
            return INST_FORM;
        }
        institutionService.save(institution);

        return "redirect:" + Forwards.COMMON_DONE;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_update")
    public String update(@ModelAttribute(COMMAND_NAME) @Valid InstitutionCommand command,
                         BindingResult bindingResult) {

        Institution institution = command.getInstitution();
        helper.checkAccess(institution, UPDATE);

        if (bindingResult.hasErrors()) {
            return INST_FORM;
        }

        return "redirect:" + Forwards.COMMON_DONE;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_approve")
    public String approve(@ModelAttribute(COMMAND_NAME) InstitutionCommand command,
                          BindingResult bindingResult) {

        Institution institution = command.getInstitution();
        helper.checkAccess(institution, APPROVE);

        if (bindingResult.hasErrors()) {
            return INST_FORM;
        }

        return "redirect:" + Forwards.COMMON_DONE;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_delete")
    public String delete(@ModelAttribute(COMMAND_NAME) InstitutionCommand command) {

        Institution institution = command.getInstitution();
        helper.checkAccess(institution, DELETE);

        return "redirect:" + Forwards.COMMON_DONE;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_return")
    public String returnToSubmitter(@ModelAttribute(COMMAND_NAME) InstitutionCommand command) {

        Institution institution = command.getInstitution();
        helper.checkAccess(institution, RETURN);

        return "redirect:" + Forwards.COMMON_DONE;
    }
}
