package dev.danvega.content_calendar.repository;

import org.springframework.stereotype.Repository;

import dev.danvega.content_calendar.model.Content;
import dev.danvega.content_calendar.model.Status;
import dev.danvega.content_calendar.model.Type;
import jakarta.annotation.PostConstruct;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> content = new ArrayList<>();


    public ContentCollectionRepository() {

    }

    public List<Content> findAll() {
        return content;
    }

    public Optional<Content> findById(Integer id) {
        return content.stream().filter(c -> c.id().equals(id)).findFirst();
    }
    
   @PostConstruct
   private void init() {
    Content c = new Content(
        1,
        "Spring detention Boot content",
        "Anamolies to spring",
        Status.IDEA,
        Type.ARTICLE,
        LocalDateTime.now(),
        null,
        ""
    );

    content.add(c);
}

public void save(Content content) {
    this.content.add(content);
}

public boolean existsById(Integer id) {
    return content.stream().anyMatch(c -> c.id().equals(id));
}

}

