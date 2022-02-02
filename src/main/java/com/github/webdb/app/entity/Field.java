package com.github.webdb.app.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Field implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String type;
    private String desc;
    private boolean notNull;
    private String defaultVal;
    private boolean index;
}
