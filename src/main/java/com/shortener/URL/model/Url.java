package com.shortener.URL.model;

import lombok.Setter;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;

@Document(collection ="urls")
@Getter
@Setter
public class Url {

    @Id
    private String id;

    private String originalUrl;

    private String shortUrl;

    private Instant expirationDate;

    /*public void setOriginalUrl(String shortUrl) {

    }

    public void setShortUrl(String shortUrl) {
    }

    public void setExpirationDate(LocalDateTime localDateTime) {
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public String getOrinalUrl() {
        return originalUrl;
    }*/
}
