package com.babar.web.question.controller;

import com.babar.web.question.helper.InstitutionHelper;
import com.babar.web.question.model.InstitutionCommand;
import com.babar.web.question.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * @author babar
 * @since 4/24/17.
 */
@Controller
@RequestMapping("/institution")
public class InstitutionController {

    private static final String INST_FORM = "inst-form";

    @Autowired
    private InstitutionHelper helper;

    @Autowired
    private InstitutionService institutionService;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show(){
        return INST_FORM;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(ModelMap modelMap) {
        helper.populateModel(modelMap);

        return INST_FORM;
    }

    @RequestMapping("/edit")
    public String edit() {
        return INST_FORM;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_save")
    public String save(@ModelAttribute("command") @Valid InstitutionCommand command,
                       BindingResult bindingResult,
                       ModelMap modelMap) {

        if (bindingResult.hasErrors()) {
            return INST_FORM;
        }

        return "";
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_update")
    public String update() {
        return "done";
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_approve")
    public String approve() {
        return "done";
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_delete")
    public String delete() {
        return "done";
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_return")
    public String returnToSubmitter() {
        return "done";
    }
}
