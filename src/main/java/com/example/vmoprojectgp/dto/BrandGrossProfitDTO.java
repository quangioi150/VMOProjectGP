package com.example.vmoprojectgp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

public class BrandGrossProfitDTO extends BaseDTO {
    @JsonInclude( JsonInclude.Include.NON_NULL )
    private String id;
    @NotBlank( message = "brand id not found in brand content type, is 7 charaters" )
    @Pattern( regexp = "\\d{7}" )
    @Field("brandId")
    private String brandId;
    @Field("payeeName")
    private String payeeName;
    @Field("bankCode")
    private String bankCode;
    @Field("event")
    private String event;
    @Field("settlementReportEmails")
    List<String> settlementReportEmails;
    @Field("dailyReportEmails")
    List<String> dailyReportEmails;
    private String taxId;
    @JsonInclude( JsonInclude.Include.NON_NULL )
    GrossProfitOldDTO before;
    GrossProfitNewDTO after;
    CompanyDTO companyInfo;
    private boolean enabled;
    GrossProfitDTO grossProfit;

    public BrandGrossProfitDTO(String id, String brandId, String payeeName, String bankCode, String event, List<String> settlementReportEmails, List<String> dailyReportEmails, String taxId, GrossProfitOldDTO before, GrossProfitNewDTO after, CompanyDTO companyInfo, boolean enabled, GrossProfitDTO grossProfit) {
        this.id = id;
        this.brandId = brandId;
        this.payeeName = payeeName;
        this.bankCode = bankCode;
        this.event = event;
        this.settlementReportEmails = settlementReportEmails;
        this.dailyReportEmails = dailyReportEmails;
        this.taxId = taxId;
        this.before = before;
        this.after = after;
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

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
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

    public CompanyDTO getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(CompanyDTO companyInfo) {
        this.companyInfo = companyInfo;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public GrossProfitDTO getGrossProfit() {
        return grossProfit;
    }

    public void setGrossProfit(GrossProfitDTO grossProfit) {
        this.grossProfit = grossProfit;
    }
}
