package com.example.vmoprojectgp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document( collection = "grossProfitNew" )
public class GrossProfitNew {
    @Id
    private double percent;
    Date effectiveDate;
    Date expiredDate;
    List<Segments> segments;
    public GrossProfitNew() {
    }
    public GrossProfitNew(double percent, Date effectiveDate, Date expiredDate, List<Segments> segments) {
        this.percent = percent;
        this.effectiveDate = effectiveDate;
        this.expiredDate = expiredDate;
        this.segments = segments;
    }
    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public List<Segments> getSegments() {
        return segments;
    }

    public void setSegments(List<Segments> segments) {
        this.segments = segments;
    }
}
