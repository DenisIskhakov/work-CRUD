package ru.sitronics.tn.transneftcontract.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Contract {
    private long id;
    private long responsibleUserId;
    private long organizationId;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "responsible_user_id")
    public long getResponsibleUserId() {
        return responsibleUserId;
    }

    public void setResponsibleUserId(long responsibleUserId) {
        this.responsibleUserId = responsibleUserId;
    }

    @Basic
    @Column(name = "organization_id")
    public long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(long organizationId) {
        this.organizationId = organizationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return id == contract.id &&
                responsibleUserId == contract.responsibleUserId &&
                organizationId == contract.organizationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, responsibleUserId, organizationId);
    }
}
