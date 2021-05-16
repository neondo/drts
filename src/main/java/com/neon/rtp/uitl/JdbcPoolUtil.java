package com.neon.rtp.uitl;

import com.alibaba.fastjson.JSONObject;
import com.neon.rtp.model.OrderWide;
import org.apache.log4j.lf5.util.StreamUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Neon
 * @date 2021/5/14 17:50
 */
public class JdbcPoolUtil{

    private static Connection connection;

    public static List<JSONObject> select(String sql) {
        try {
            connection.setAutoCommit(true);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<JSONObject> j = new ArrayList<>();
            while(resultSet.next()) {
                String v = resultSet.getString(resultSet.getRow());
                JSONObject jsonObject = new JSONObject();
                jsonObject.put(v, v);
                j.add(jsonObject);
            }
            return j;
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }

    public static <T> void batchInsert(List<T> insertList) {
        try {
            String sql = getSql(insertList);
            connection.setAutoCommit(true);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int[] ints = preparedStatement.executeBatch();
            ResultSet resultSet = preparedStatement.getResultSet();
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static <T> String getSql(List<T> orderWideList) {
        return "";
    }
}
