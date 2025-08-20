package com.shortener.URL.controller;

import com.shortener.URL.model.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.shortener.URL.services.UrlService;

import java.net.URI;
import java.util.Map;

@Controller
public class UrlController {

    @Autowired
    private UrlService urlService;

    @GetMapping("/")
    public String serveHomePage() {
        return "index.html";
    }

    @PostMapping("/api/shorten")
    @ResponseBody
    public ResponseEntity<Map<String, String>> shortenUrl(@RequestBody Map<String, String> request) {
        String originalUrl = request.get("url");
        Url savedUrl = urlService.shorterUrl(originalUrl);

        String responseUrl = "http://localhost:8080/r/" + savedUrl.getShortUrl();

        return ResponseEntity.ok(Map.of("shortUrl", responseUrl));
    }

    @GetMapping("/r/{shortUrl}")
    public ResponseEntity<Void> redirectToOriginalUrl(@PathVariable String shortUrl) {
        Url url = urlService.getOriginalUrl(shortUrl);
        return ResponseEntity.status(302).location(URI.create(url.getOriginalUrl())).build();
    }
}