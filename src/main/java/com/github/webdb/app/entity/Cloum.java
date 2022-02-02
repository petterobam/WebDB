package com.github.webdb.app.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Cloum implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private Object val;
}
