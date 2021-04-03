package com.ytt.demo.pojo;


public class View {
//    序号
    private String id;
//    差异试图名称
    private String viewName;
//    结构变更
    private String strucChange;
//    相关需求
    private String Needs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public String getStrucChange() {
        return strucChange;
    }

    public void setStrucChange(String strucChange) {
        this.strucChange = strucChange;
    }

    public String getNeeds() {
        return Needs;
    }

    public void setNeeds(String needs) {
        Needs = needs;
    }

    public View(String id, String viewName, String strucChange, String needs) {
        this.id = id;
        this.viewName = viewName;
        this.strucChange = strucChange;
        Needs = needs;
    }
}
