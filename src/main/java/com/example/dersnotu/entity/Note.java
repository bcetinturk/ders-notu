package com.example.dersnotu.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Data
@Document(indexName = "note")
public class Note {
    @Id
    private String id;
    private String lectureName;
    private String lectureNote;
    private String ownerId;
    private final Date creationDate = new Date();
    private String lecturerName;
}
