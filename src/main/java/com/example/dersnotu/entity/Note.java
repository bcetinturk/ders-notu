package com.example.dersnotu.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.util.Date;

@Data
@Document(indexName = "note")
@Setting(settingPath = "es-analysis.json")
public class Note {
    @Id
    private String id;
    @Field(type = FieldType.Text, analyzer = "autocomplete_index", searchAnalyzer = "autocomplete_search")
    private String lectureName;
    private String lectureNote;
    private String ownerId;
    private final Date creationDate = new Date();
    private String lecturerName;
}
