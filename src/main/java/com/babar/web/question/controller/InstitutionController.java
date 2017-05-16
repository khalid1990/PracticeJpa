package com.babar.web.question.controller;

import com.babar.db.entity.Institution;
import com.babar.web.common.Forwards;
import com.babar.web.common.ViewMode;
import com.babar.web.question.helper.InstitutionHelper;
import com.babar.web.question.model.InstitutionCommand;
import com.babar.web.question.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(ModelMap modelMap) {

        Institution institution = helper.createNewInstitution();
        helper.populateModel(modelMap, institution, ViewMode.EDITABLE);

        return INST_FORM;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show(@RequestParam("id") int id, ModelMap modelMap){

        Institution institution = institutionService.find(id);
        helper.populateModel(modelMap, institution, ViewMode.READ_ONLY);

        return INST_FORM;
    }

    @RequestMapping("/edit")
    public String edit(@RequestParam("id") int id, ModelMap modelMap) {
        Institution institution = institutionService.find(id);
        helper.populateModel(modelMap, institution, ViewMode.EDITABLE);

        return INST_FORM;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_save")
    public String save(@ModelAttribute(COMMAND_NAME) @Valid InstitutionCommand command,
                       BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return INST_FORM;
        }

        return "redirect:" + Forwards.COMMON_DONE;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_update")
    public String update(@ModelAttribute(COMMAND_NAME) @Valid InstitutionCommand command,
                         BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return INST_FORM;
        }

        return "redirect:" + Forwards.COMMON_DONE;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_approve")
    public String approve(@ModelAttribute(COMMAND_NAME) InstitutionCommand command,
                          BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return INST_FORM;
        }

        return "redirect:" + Forwards.COMMON_DONE;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_delete")
    public String delete() {
        return "redirect:" + Forwards.COMMON_DONE;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_return")
    public String returnToSubmitter() {
        return "redirect:" + Forwards.COMMON_DONE;
    }
}
