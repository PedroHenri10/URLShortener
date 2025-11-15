package com.shortener.URL.services;

import com.shortener.URL.dto.UrlRequest;
import com.shortener.URL.exceptions.InvalidUrlException;
import com.shortener.URL.exceptions.UrlNotFoundException;
import com.shortener.URL.model.Url;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shortener.URL.repository.UrlRepository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.Random;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    public Url shorterUrl(UrlRequest request) {

        if (request.getUrl() == null || request.getUrl().isEmpty()) {
            throw new InvalidUrlException("URL cannot be empty.");
        }
        UrlValidator urlValidator = new UrlValidator(new String[]{"http", "https"});
        if (!urlValidator.isValid(request.getUrl())) {
            throw new InvalidUrlException("The provided URL is not valid.");
        }

        int days = request.getDays() > 0 ? request.getDays() : 30;

        String shortUrl = generateShortUrl();
        Url url = new Url();
        url.setOriginalUrl(request.getUrl());
        url.setShortUrl(shortUrl);
        url.setExpirationDate(Instant.now().plus(days, ChronoUnit.DAYS));
        return urlRepository.save(url);
    }

    public Url getOriginalUrl(String shortUrl) {
        Url url = urlRepository.findByShortUrl(shortUrl)
                .orElseThrow(() -> new UrlNotFoundException("Short URL not found: " + shortUrl));

        if (url.getExpirationDate().isBefore(Instant.now())) {
            urlRepository.delete(url);
            throw new UrlNotFoundException("URL has expired and was deleted.");
        }
        return url;
    }

    private String generateShortUrl() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder shortUrl = new StringBuilder();
        Random random = new Random();
        int length = 7;
        for (int i = 0; i < length; i++) {
            shortUrl.append(characters.charAt(random.nextInt(characters.length())));
        }
        return shortUrl.toString();
    }
}