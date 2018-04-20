package com.muzi.annotations.mybatis;

import com.muzi.db.DBUtil;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by muzi on 2018/4/19.
 */
public final class DaoOperatorFactory {

    /**
     * handle
     * @param method
     * @param params
     * @return
     * @throws SQLException
     */
    public static Object handle(Method method, Object[] params) throws SQLException {
        String sql = null;
        if (method.isAnnotationPresent(Insert.class)) {
            sql = checkSql(sql, Insert.class.getSimpleName());
            insert(sql, params);
            return null;
        }
        return null;
    }

    /**
     * 插入操作
     * @param sql
     * @param params
     * @throws SQLException
     */
    private static void insert(String sql, Object[] params) throws SQLException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1, params[i]);
        }
        preparedStatement.execute();
    }

    /**
     * 检查sql是否符合指定sql关键开头
     * @param sql
     * @param type
     * @return
     * @throws SQLException
     */
    private static String checkSql(String sql, String type) throws SQLException {
        String type1 = sql.split(" ")[0];
        if (type == null || !type.equalsIgnoreCase(type1)) {
            throw new SQLException("error sql");
        }
        return sql;
    }
}
