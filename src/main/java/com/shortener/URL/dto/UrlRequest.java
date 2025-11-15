package com.shortener.URL.dto;

public class UrlRequest {
    private String url;
    private int days;

    public int getDays() {
        return days;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
