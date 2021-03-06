package com.example.dersnotu.repository;

import com.example.dersnotu.entity.Note;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface NoteRepository extends ElasticsearchRepository<Note, String> {
    List<Note> findAllByLectureName(String lectureName, Pageable pageable);
    List<Note> findAllByOwnerId(String ownerId,  Pageable pageable);

    @Query("{\"bool\": {\"must\": {\"terms\": {\"_id\": ?0}}}}")
    List<Note> findFavNotesFromIds(String jsonArray);
}
