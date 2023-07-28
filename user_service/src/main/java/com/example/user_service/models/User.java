package com.example.user_service.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "user")
@Data
public class User {

    @Id
    @Indexed(unique = true)
    private String userId;
    private String name;
    private String email;
    private String about;


}
