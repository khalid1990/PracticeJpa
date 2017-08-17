package com.babar.web.question.controller;

import com.babar.db.entity.Institution;
import com.babar.web.common.ControllerUtils;
import com.babar.web.common.Forwards;
import com.babar.web.common.ViewMode;
import com.babar.web.question.helper.InstitutionHelper;
import com.babar.web.question.model.InstitutionCommand;
import com.babar.web.question.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import static com.babar.web.common.Action.*;

/**
 * @author babar
 * @since 4/24/17.
 */
/*
* Here I have used the @SessionAttributes and passed it a attribute name,
* if an object is set in the model attribute with the same name then
* that object will also be stored in the session; So when a form is submitted
* it will look for the form backing object that is the command object in the session,
* it will take the object from session (if found) and update the relevant fields
* with request parameters found from form submission.
*
* The object will be stored with the same name that is passed as argument
* to the @SessionAttributes annotation in a default scenario. However this default
* behavior can be modified by setting up a custom sessionAttributeStore
* in the sessionAttributeStore parameter of RequestMappingHandlerAdapter.
* I have my own custom implementation which is named
* CommonSessionAttributeStore which extends DefaultSessionAttributeStore.
* Some improvement to this class will solve multi tab issue for the same
* and different form.
*
* */
@Controller
@RequestMapping("/institution")
@SessionAttributes(InstitutionController.COMMAND_NAME)
public class InstitutionController {

    private static final String INST_FORM = "inst-form";

    private static final String LIST_VIEW = "instListView";

    public static final String COMMAND_NAME = "command";

    @Autowired
    private InstitutionHelper helper;

    @Autowired
    private InstitutionService institutionService;

    @Autowired
    private MessageSourceAccessor msa;

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
        helper.populateModel(modelMap, institution, ViewMode.EDITABLE);

        return INST_FORM;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show(@RequestParam("id") int id, ModelMap modelMap){

        Institution institution = institutionService.find(id);
        helper.checkAccess(institution, VIEW);
        helper.populateModel(modelMap, institution, ViewMode.READ_ONLY);

        return INST_FORM;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam("id") int id, ModelMap modelMap) {

        Institution institution = institutionService.find(id);
        helper.checkAccess(institution, UPDATE);
        helper.populateModel(modelMap, institution, ViewMode.EDITABLE);

        return INST_FORM;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(@RequestParam(value = "currentIndex", required = false, defaultValue = "0") int currentIndex,
                       @RequestParam(value = "sortProperty", required = false) String sortProperty,
                       @RequestParam(value = "sortOrder", required = false) String sortOrder,
                       ModelMap modelMap) {
        helper.populateModelWithListTableInfo(currentIndex, sortOrder, sortProperty, modelMap);

        return LIST_VIEW;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_save")
    public String save(@ModelAttribute(COMMAND_NAME) @Valid InstitutionCommand command,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {

        Institution institution = command.getInstitution();
        helper.checkAccess(institution, SAVE);

        if (bindingResult.hasErrors()) {
            return INST_FORM;
        }
        institutionService.save(institution);

        return ControllerUtils.redirectToCommon(redirectAttributes,
                msa.getMessage("msg.save.successful", new String[]{"Institution"}),
                helper.getShowUrl(institution.getId(), null));
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_update")
    public String update(@ModelAttribute(COMMAND_NAME) @Valid InstitutionCommand command,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        Institution institution = command.getInstitution();
        helper.checkAccess(institution, UPDATE);

        if (bindingResult.hasErrors()) {
            return INST_FORM;
        }
        institutionService.update(institution);

        return ControllerUtils.redirectWithMessage(redirectAttributes,
                msa.getMessage("msg.update.successful", new String[]{"Institution"}),
                helper.getShowUrl(institution.getId(), null));
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_submit")
    public String submit(@ModelAttribute(COMMAND_NAME) @Valid InstitutionCommand command,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        Institution institution = command.getInstitution();
        helper.checkAccess(institution, SUBMIT);

        if (bindingResult.hasErrors()) {
            return INST_FORM;
        }
        institutionService.submit(institution);

        return ControllerUtils.redirectWithMessage(redirectAttributes,
                msa.getMessage("msg.submit.successful", new String[]{"Institution"}),
                helper.getShowUrl(institution.getId(), null));
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_approve")
    public String approve(@ModelAttribute(COMMAND_NAME) InstitutionCommand command,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {

        Institution institution = command.getInstitution();
        helper.checkAccess(institution, APPROVE);

        if (bindingResult.hasErrors()) {
            return INST_FORM;
        }
        institutionService.approve(institution);

        return ControllerUtils.redirectWithMessage(redirectAttributes,
                msa.getMessage("msg.approve.successful", new String[]{"Institution"}),
                helper.getShowUrl(institution.getId(), null));
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_delete")
    public String delete(@ModelAttribute(COMMAND_NAME) InstitutionCommand command,
                         RedirectAttributes redirectAttributes) {

        Institution institution = command.getInstitution();
        helper.checkAccess(institution, DELETE);
        institutionService.delete(institution);

        return ControllerUtils.redirectWithMessage(redirectAttributes,
                msa.getMessage("msg.delete.successful", new String[]{"Institution"}),
                helper.getShowUrl(institution.getId(), null));
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_return")
    public String returnToSubmitter(@ModelAttribute(COMMAND_NAME) InstitutionCommand command,
                                    RedirectAttributes redirectAttributes) {

        Institution institution = command.getInstitution();
        helper.checkAccess(institution, RETURN);
        institutionService.returnToSubmitter(institution);

        return ControllerUtils.redirectWithMessage(redirectAttributes,
                msa.getMessage("msg.return.successful", new String[]{"Institution"}),
                helper.getShowUrl(institution.getId(), null));
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_back")
    public String back(@ModelAttribute(COMMAND_NAME) InstitutionCommand command,
                       SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return ControllerUtils.redirect(command.getBackLink());
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_back_show")
    public String backToShow(@ModelAttribute(COMMAND_NAME) InstitutionCommand command,
                       SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return ControllerUtils.redirect(helper.getShowUrl(command.getInstitution().getId(), command.getBackLink()));
    }

    @RequestMapping(value = "index", method = RequestMethod.POST, params = "_action_cancel")
    public String cancel(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return ControllerUtils.redirectToDashboard();
    }
}
