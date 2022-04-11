package com.zyapaar.api.pyloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private String id;

    @NotEmpty
    @Size(min = 4,message = "user name must be min 4 characters")
    private String name;

    @Email(message = "email is not valid")
    private String email;

    @NotNull(message = "password must be not null")
//    @Size
//    @Pattern(regexp = )
    private String password;


    private String  about;
}
