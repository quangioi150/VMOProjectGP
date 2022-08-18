package com.example.vmoprojectgp.dto;

public class SegmentsDTO {
    private String type;
    private double value;
    public SegmentsDTO(String type, double value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public SegmentsDTO() {
    }
}
