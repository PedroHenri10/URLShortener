package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UrlRepository;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    public String shorterUrl(String originalUrl){
        return "";
    }

    private String generateShortUrl(){
        String characteres = "JubISCREITONREMOArseNalmenkkiaKaKAROTTOMUNASDIO";
    }
}
