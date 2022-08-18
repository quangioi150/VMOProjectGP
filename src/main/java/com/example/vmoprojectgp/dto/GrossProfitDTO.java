package com.example.vmoprojectgp.dto;

import java.time.ZonedDateTime;
import java.util.List;

public class GrossProfitDTO {
    private double percent;
    ZonedDateTime effectiveDate;
    ZonedDateTime expiredDate;
    List<SegmentsDTO> segments;

    public GrossProfitDTO(double percent, ZonedDateTime effectiveDate, ZonedDateTime expiredDate, List<SegmentsDTO> segments) {
        this.percent = percent;
        this.effectiveDate = effectiveDate;
        this.expiredDate = expiredDate;
        this.segments = segments;
    }

    public GrossProfitDTO() {
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public ZonedDateTime getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(ZonedDateTime effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public ZonedDateTime getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(ZonedDateTime expiredDate) {
        this.expiredDate = expiredDate;
    }

    public List<SegmentsDTO> getSegments() {
        return segments;
    }

    public void setSegments(List<SegmentsDTO> segments) {
        this.segments = segments;
    }
}
