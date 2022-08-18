package com.example.vmoprojectgp.dto;

import com.example.vmoprojectgp.entity.GrossProfitNew;
import com.example.vmoprojectgp.entity.GrossProfitOld;

import java.time.Instant;
import java.time.ZonedDateTime;

public class BrandGrossProfitAuditLogDTO {
    private String id;
    private String event;
    private String brandId;
    GrossProfitOldDTO before;
    GrossProfitNewDTO after;
    Instant auditedDate;

    public BrandGrossProfitAuditLogDTO() {
    }

    public BrandGrossProfitAuditLogDTO(String id, String event, String brandId, GrossProfitOldDTO before, GrossProfitNewDTO after, Instant auditedDate) {
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

    public GrossProfitOldDTO getBefore() {
        return before;
    }

    public void setBefore(GrossProfitOldDTO before) {
        this.before = before;
    }

    public GrossProfitNewDTO getAfter() {
        return after;
    }

    public void setAfter(GrossProfitNewDTO after) {
        this.after = after;
    }

    public Instant getAuditedDate() {
        return auditedDate;
    }

    public void setAuditedDate(Instant auditedDate) {
        this.auditedDate = auditedDate;
    }
}
