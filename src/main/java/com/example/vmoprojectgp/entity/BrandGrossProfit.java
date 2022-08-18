package com.example.vmoprojectgp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document( collection = "brandGrossProfit" )
public class BrandGrossProfit extends BaseEntity {
    @Id
    private String id;
    private String brandId;
    private String payeeName;
    private String bankCode;
    private String event;
    List<String> settlementReportEmails;
    List<String> dailyReportEmails;
    GrossProfitOld before;
    GrossProfitNew after;
    private String taxId;
    Company companyInfo;
    private boolean enabled;
    GrossProfit grossProfit;

    public BrandGrossProfit(String id, String brandId, String payeeName, String bankCode, String event, List<String> settlementReportEmails, List<String> dailyReportEmails, GrossProfitOld before, GrossProfitNew after, String taxId, Company companyInfo, boolean enabled, GrossProfit grossProfit) {
        this.id = id;
        this.brandId = brandId;
        this.payeeName = payeeName;
        this.bankCode = bankCode;
        this.event = event;
        this.settlementReportEmails = settlementReportEmails;
        this.dailyReportEmails = dailyReportEmails;
        this.before = before;
        this.after = after;
        this.taxId = taxId;
        this.companyInfo = companyInfo;
        this.enabled = enabled;
        this.grossProfit = grossProfit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public List<String> getSettlementReportEmails() {
        return settlementReportEmails;
    }

    public void setSettlementReportEmails(List<String> settlementReportEmails) {
        this.settlementReportEmails = settlementReportEmails;
    }

    public List<String> getDailyReportEmails() {
        return dailyReportEmails;
    }

    public void setDailyReportEmails(List<String> dailyReportEmails) {
        this.dailyReportEmails = dailyReportEmails;
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

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public Company getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(Company companyInfo) {
        this.companyInfo = companyInfo;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public GrossProfit getGrossProfit() {
        return grossProfit;
    }

    public void setGrossProfit(GrossProfit grossProfit) {
        this.grossProfit = grossProfit;
    }
}
