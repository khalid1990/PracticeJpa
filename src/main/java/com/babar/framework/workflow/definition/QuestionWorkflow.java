package com.babar.framework.workflow.definition;

import com.babar.framework.workflow.AuthorizedFormWorkflow;
import com.babar.framework.workflow.FormWorkflow;

import static com.babar.db.common.enums.FormStatus.*;
import static com.babar.framework.workflow.RoleAction.with;
import static com.babar.security.Role.*;
import static com.babar.web.common.Action.*;

/**
 * @author babar
 * @since 8/7/17.
 */
public class QuestionWorkflow {
    public static AuthorizedFormWorkflow getFlow() {
        return new AuthorizedFormWorkflow(FormWorkflow.getFormWorkflow().

                in(NEW).
                on(SAVE).to(DRAFT).
                in(DRAFT).
                on(UPDATE).to(DRAFT).
                on(SUBMIT).to(PENDING_APPROVAL).
                on(DELETE).to(DELETED).
                in(PENDING_APPROVAL).
                on(UPDATE).to(PENDING_APPROVAL).
                on(APPROVE).to(APPROVED).
                on(RETURN).to(RETURNED).
                on(DELETE).to(DELETED).
                in(APPROVED).
                on(UPDATE).to(PENDING_UPDATE_APPROVAL).
                on(RETURN).to(RETURNED).
                on(DELETE).to(DELETED).
                in(PENDING_UPDATE_APPROVAL).
                on(UPDATE).to(PENDING_UPDATE_APPROVAL).
                on(APPROVE).to(APPROVED).
                on(RETURN).to(RETURNED).
                in(RETURNED).
                on(UPDATE).to(RETURNED).
                on(SUBMIT).to(PENDING_APPROVAL).
                on(DELETE).to(DELETED).
                in(DELETED).noAction(),

                with(QUESTION_CREATE).in(NEW).can(SAVE),

                with(QUESTION_UPDATE).in(DRAFT, PENDING_APPROVAL, APPROVED, PENDING_UPDATE_APPROVAL, RETURNED).can(UPDATE),

                with(QUESTION_SUBMIT).in(DRAFT, RETURNED).can(SUBMIT),

                with(QUESTION_APPROVE).in(PENDING_APPROVAL, PENDING_UPDATE_APPROVAL).can(APPROVE),

                with(QUESTION_RETURN).in(PENDING_APPROVAL, PENDING_UPDATE_APPROVAL).can(RETURN),

                with(QUESTION_DELETE).in(DRAFT, PENDING_APPROVAL, APPROVED, PENDING_UPDATE_APPROVAL, RETURNED).can(DELETE)
        );
    }
}
