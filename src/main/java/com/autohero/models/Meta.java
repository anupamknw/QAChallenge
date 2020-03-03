package com.autohero.models;

import java.util.List;

public class Meta {

    private List<String> fields = null;
    private Integer from;
    private String locale;
    private Location location;
    private Boolean published;
    private RegistrationDate registrationDate;
    private List<Integer> sellerType = null;
    private Integer size;
    private List<Sort> sort = null;
    private List<String> retailAdState = null;

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public RegistrationDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(RegistrationDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public List<Integer> getSellerType() {
        return sellerType;
    }

    public void setSellerType(List<Integer> sellerType) {
        this.sellerType = sellerType;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public List<Sort> getSort() {
        return sort;
    }

    public void setSort(List<Sort> sort) {
        this.sort = sort;
    }

    public List<String> getRetailAdState() {
        return retailAdState;
    }

    public void setRetailAdState(List<String> retailAdState) {
        this.retailAdState = retailAdState;
    }

}

