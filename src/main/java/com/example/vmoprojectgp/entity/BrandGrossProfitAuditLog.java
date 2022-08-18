package com.example.vmoprojectgp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document( collection = "brandGrossProfitAuditLog" )
public class BrandGrossProfitAuditLog extends BaseEntity {
    @Id
    private String id;
    private String event;
    private String brandId;
    GrossProfitOld before;
    GrossProfitNew after;
    Instant auditedDate = Instant.now();

    public BrandGrossProfitAuditLog() {
    }

    public BrandGrossProfitAuditLog(String id, String event, String brandId, GrossProfitOld before, GrossProfitNew after, Instant auditedDate) {
        this.id = id;
        this.event = event;
        this.brandId = brandId;
        this.before = before;
        this.after = after;
        this.auditedDate = auditedDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public GrossProfitOld getBefore() {
        return before;
    }

    public void setBefore(GrossProfitOld before) {
        this.before = before;
    }

    public GrossProfitNew getAfter() {
        return after;
    }

    public void setAfter(GrossProfitNew after) {
        this.after = after;
    }

    public Instant getAuditedDate() {
        return auditedDate;
    }

    public void setAuditedDate(Instant auditedDate) {
        this.auditedDate = auditedDate;
    }
}
