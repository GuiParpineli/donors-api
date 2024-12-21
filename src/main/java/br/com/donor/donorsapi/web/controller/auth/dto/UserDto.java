package br.com.donor.donorsapi.web.controller.auth.dto;

import br.com.donor.donorsapi.adapters.persistence.entity.UserEntity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link UserEntity}
 */
public record UserDto(@NotNull @NotEmpty String username,
                      @NotNull @NotEmpty(message = "password cannot be empty") String password) implements Serializable {
}
