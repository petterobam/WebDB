package com.github.webdb.app.pojo.vo;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Sql执行
 *
 * @author 欧阳洁
 * @date 2021/5/27 0:27
 */
public class SqlExecuteContext {
    /**
     * Sql语句
     */
    private String sql;
    /**
     * 数据库类型
     */
    private String type;
    /**
     * 库名
     */
    private String dbName;
    /**
     * 查询结果集
     */
    private List<Map<String, Object>> queryResult;
    /**
     * 命令行执行结果
     */
    private String cmdResult;
    /**
     * 影响行数
     */
    private int infactLine;
    /**
     * SQL语句执行异常
     */
    private SQLException sqlException;
    /**
     * 程序异常
     */
    private Exception exception;
    /**
     * 是否存在异常
     */
    private boolean hasException = false;
}
