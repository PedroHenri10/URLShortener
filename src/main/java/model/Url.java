package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String originalUrl;

    private String shortUrl;

    private LocalDateTime expirationDate;

    public void setOriginalUrl(String shortUrl) {

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
    }
}
