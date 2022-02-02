package com.github.webdb.app.entity;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Table implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private List<Row> rows;
    private List<Field> fields;
    private List<Index> indexs;
    private Field pkField;
    private Index pkIndex;
}
