package com.babar.entity;

import com.babar.common.enums.FormStatus;

import javax.persistence.*;
import java.util.Date;

/**
 * @author babar
 * @since 2/23/17.
 */
@MappedSuperclass
public class Persistence {

    @Enumerated(EnumType.STRING)
    private FormStatus status;

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private User createdBy;

    private Date created;

    @ManyToOne
    @JoinColumn(name = "updated_by_id")
    private User updatedBy;

    private Date updated;

    @ManyToOne
    @JoinColumn(name = "approved_by_id")
    private User approvedBy;

    private Date approveDate;

    @ManyToOne
    @JoinColumn(name = "returned_by_id")
    private User returnedBy;

    private Date returnDate;

    @ManyToOne
    @JoinColumn(name = "deleted_by_id")
    private User deletedBy;

    private Date deleteDate;

    private String returnReason;

    private String deleteReason;

    public FormStatus getStatus() {
        return status;
    }

    public void setStatus(FormStatus status) {
        this.status = status;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public User getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(User approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public User getReturnedBy() {
        return returnedBy;
    }

    public void setReturnedBy(User returnedBy) {
        this.returnedBy = returnedBy;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public User getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(User deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

    public String getReturnReason() {
        return returnReason;
    }

    public void setReturnReason(String returnReason) {
        this.returnReason = returnReason;
    }

    public String getDeleteReason() {
        return deleteReason;
    }

    public void setDeleteReason(String deleteReason) {
        this.deleteReason = deleteReason;
    }
}
