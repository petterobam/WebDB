package com.github.webdb.app.entity;

import java.io.Serializable;
import java.util.Map;

import lombok.Data;

@Data
public class Row implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<String, Cloum> fields;
}
