package dev.kaykyfreitas.springboottemplate.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public abstract class ApiDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

}
