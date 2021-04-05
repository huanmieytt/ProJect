package com.ytt.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SqlBuilder {
    public PreparedStatement sts = null;
    public ResultSet rs = null;
    //    查询旧库下的所有视图
    public  List<String> selectOldViews(Connection oldConn) throws Exception {
        try {
            String sql = "select table_name from  information_schema.views where TABLE_SCHEMA ='springboot'";
            List<String>  oldViews = new ArrayList<String>();
            sts=oldConn.prepareStatement(sql);
            rs = sts.executeQuery();
            while(rs.next()){
                String viewName=  rs.getString("table_name");
                oldViews.add(viewName);
            }
            return oldViews;

        }catch (Exception ex){
            throw new Exception("查询旧库的视图出错！！",ex);
        }finally {
            sts.close();
            rs.close();
        }
    }


    //    获取旧视图所有字段
    public List<String> selectOldViewsColumnName(String viewName,Connection oldConn) throws Exception {
        try {
            String sql = "select COLUMN_NAME,DATA_TYPE,COLUMN_COMMENT from information_schema.COLUMNS where table_name = ?  and table_schema = 'springboot'";
            List<String>  oldViewNames = new ArrayList<String>();
            sts=oldConn.prepareStatement(sql);
            sts.setString(1,viewName);
            rs = sts.executeQuery();
            while(rs.next()){
                String viewColumnName=  rs.getString("COLUMN_NAME");
                oldViewNames.add(viewColumnName);
            }
            return oldViewNames;

        }catch (Exception ex){
            throw new Exception("查询旧视图的字段出错！！",ex);
        }finally {
            sts.close();
            rs.close();
        }
    }

    //    获取新视图所有字段
    public List<String> selectNewViewsColumnName(String viewName,Connection newConn) throws Exception {
        try {
//            注意视图名 where table_name = ?  ，我这里给写死了
            String sql = "select COLUMN_NAME,DATA_TYPE,COLUMN_COMMENT from information_schema.COLUMNS where table_name = ? and table_schema = 'sys'";
            List<String>  newViewNames = new ArrayList<String>();
            sts=newConn.prepareStatement(sql);
            sts.setString(1,viewName);
            rs = sts.executeQuery();
            while(rs.next()){
                String viewColumnName=  rs.getString("COLUMN_NAME");
                newViewNames.add(viewColumnName);
            }
            return newViewNames;

        }catch (Exception ex){
            throw new Exception("查询旧视图的字段出错！！",ex);
        }finally {
            sts.close();
            rs.close();
        }
    }
}
