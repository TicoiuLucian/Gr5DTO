package com.example.dto.rest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    private Long id;

    private String username;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;

    public UserDTO(Long id, String username) {
        this.id = id;
        this.username = username;
    }
}
