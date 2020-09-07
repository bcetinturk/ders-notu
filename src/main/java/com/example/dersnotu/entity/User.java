package com.example.dersnotu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "lecturenotes")
public class User {
    @Id
    private String id;
    private String fullName;
    private String email;
    private String password;
    private String university;
    private String department;
    private String profilePictureUrl="https://i.ibb.co/Yp8dK7B/default-profile.png";
}