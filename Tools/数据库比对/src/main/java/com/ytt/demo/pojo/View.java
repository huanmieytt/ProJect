package com.ytt.demo.pojo;


public class View {
//    序号
    private int id;
//    差异试图名称
    private String viewName;
//    增加字段
    private String addColumn;
//     删除字段
    private String delColumn;
//    相关需求
    private String Needs;


    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public String getNeeds() {
        return Needs;
    }

    public void setNeeds(String needs) {
        Needs = needs;
    }


    public String getAddColumn() {
        return addColumn;
    }

    public void setAddColumn(String addColumn) {
        this.addColumn = addColumn;
    }

    public String getDelColumn() {
        return delColumn;
    }

    public void setDelColumn(String delColumn) {
        this.delColumn = delColumn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
