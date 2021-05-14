package com.neon.rtp.uitl;

import com.alibaba.fastjson.JSONObject;

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
        }
        return new ArrayList<>();
    }
}
