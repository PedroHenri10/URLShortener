package repository;

import model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UrlRepository extends MongoRepository<Url,String> {

    Optional<Url> findByShortUrl(String shortUrl);
}
