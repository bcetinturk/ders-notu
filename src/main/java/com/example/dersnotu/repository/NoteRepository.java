package com.example.dersnotu.repository;

import com.example.dersnotu.entity.Note;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface NoteRepository extends ElasticsearchRepository<Note, String> {
}
