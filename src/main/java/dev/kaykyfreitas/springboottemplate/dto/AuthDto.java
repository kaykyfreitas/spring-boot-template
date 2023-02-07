package dev.kaykyfreitas.springboottemplate.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


@Data
@EqualsAndHashCode(callSuper = true)
public final class AuthDto extends ApiDto {

    private final String username;

    private final String token;

    private final List<String> roles;

}
