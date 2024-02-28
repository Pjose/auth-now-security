package org.authnow.security.dto;

import org.authnow.security.model.User;

public record TokenDTO(
    Integer id,
    String token,
    boolean revoked,
    boolean expired,
    User user
) {

}
