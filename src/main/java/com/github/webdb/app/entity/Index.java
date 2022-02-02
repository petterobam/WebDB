package com.github.webdb.app.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class Index implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<Object, List<Long>> finder;
}
