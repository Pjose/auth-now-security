package org.authnow.security.dto;

import org.authnow.security.model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenDTO {

    private String token;
    private boolean revoked;
    private boolean expired;
    private User user;
}
