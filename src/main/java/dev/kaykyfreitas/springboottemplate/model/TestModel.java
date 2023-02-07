package dev.kaykyfreitas.springboottemplate.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TestModel extends ApiModel {

    private String name;

    private Integer age;

    public TestModel(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}
