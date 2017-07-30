package com.babar.framework.workflow;

import com.babar.db.common.enums.FormStatus;
import com.babar.framework.workflow.definition.InstitutionWorkflow;
import com.babar.framework.workflow.definition.QuestionPaperWorkflow;
import com.babar.security.Role;
import com.babar.utils.Util;
import com.babar.web.common.Action;
import com.babar.web.common.ActionView;
import com.babar.web.common.ViewMode;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.babar.framework.workflow.FormType.FT_INSTITUTION;
import static com.babar.framework.workflow.FormType.FT_QUESTION_PAPER;

/**
 * @author babar
 * @since 3/25/17.
 */
public class WorkflowManager {

    private static Map<FormType, AuthorizedFormWorkflow> wfEngine = new HashMap<>();

    static {
        wfEngine.put(FT_QUESTION_PAPER, QuestionPaperWorkflow.getFlow());
        wfEngine.put(FT_INSTITUTION, InstitutionWorkflow.getFlow());
    }

    public static FormStatus getNextStatus(FormType formType, FormStatus status, Action action) {

        if (status == null) {
            throw new UnsupportedOperationException("This operation is not supported");
        }

        return wfEngine.get(formType).getNextStatus(status, action);
    }

    public static ActionView getActionView(FormType formType, FormStatus formStatus, ViewMode viewMode, List<Role> roles) {
        List<Action> allowedActions = getAllowedActions(formType, formStatus, roles);

        return new ActionView(viewMode, allowedActions);
    }

    private static List<Action> getAllowedActions(FormType formType, FormStatus currentStatus, List<Role> roles) {

        if (Util.isAnyNull(formType, currentStatus) || CollectionUtils.isEmpty(roles)) {
            throw new UnsupportedOperationException("This operation is not supported");
        }

        return wfEngine.get(formType).getAllowedActions(currentStatus, roles);
    }
}
