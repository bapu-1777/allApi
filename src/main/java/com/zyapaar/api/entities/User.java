package com.zyapaar.api.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "user")
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    private String id;


    private String name;

    private String email;

    private String password;

    private String  about;

	

	
	
}
