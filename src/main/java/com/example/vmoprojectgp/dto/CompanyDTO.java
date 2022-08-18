package com.example.vmoprojectgp.dto;

public class CompanyDTO {
private String name;
private String address;
private String subDistrict;
private String district;
private String province;
private String postcode;

    public CompanyDTO(String name, String address, String subDistrict, String district, String province, String postcode) {
        this.name = name;
        this.address = address;
        this.subDistrict = subDistrict;
        this.district = district;
        this.province = province;
        this.postcode = postcode;
    }

    public CompanyDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSubDistrict() {
        return subDistrict;
    }

    public void setSubDistrict(String subDistrict) {
        this.subDistrict = subDistrict;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
