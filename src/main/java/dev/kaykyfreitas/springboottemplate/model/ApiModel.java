package dev.kaykyfreitas.springboottemplate.model;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public abstract class ApiModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private UUID id = UUID.randomUUID();

    private LocalDateTime createdAt = LocalDateTime.now();

}
