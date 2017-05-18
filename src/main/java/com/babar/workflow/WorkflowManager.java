package com.babar.framework.workflow;

import com.babar.db.common.enums.FormStatus;
import com.babar.framework.workflow.definition.QuestionPaperWorkflow;
import com.babar.security.Role;
import com.babar.utils.Util;
import com.babar.web.common.Action;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.babar.framework.workflow.FormType.FT_QUESTION_PAPER;

/**
 * @author babar
 * @since 3/25/17.
 */
public class WorkflowManager {
    private static Map<FormType, AuthorizedFormWorkflow> wfEngine = new HashMap<>();

    static {
        wfEngine.put(FT_QUESTION_PAPER, QuestionPaperWorkflow.getFlow());
    }

    public static FormStatus getNextStatus(FormType formType, FormStatus status, Action action) {

        if (Util.isAnyNull(formType, status, action)) {
            throw new UnsupportedOperationException("This operation is not supported");
        }

        return wfEngine.get(formType).getNextStatus(status, action);
    }

    public List<Action> getAllowedActions(FormType formType, FormStatus currentStatus, List<Role> roles) {

        if (Util.isAnyNull(formType, currentStatus) || CollectionUtils.isEmpty(roles)) {
            throw new UnsupportedOperationException("This operation is not supported");
        }

        return wfEngine.get(formType).getAllowedActions(currentStatus, roles);
    }
}
