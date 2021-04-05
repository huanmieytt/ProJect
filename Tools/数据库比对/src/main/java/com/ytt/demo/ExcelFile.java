package com.ytt.demo;



import com.ytt.demo.dao.SqlBuilder;
import com.ytt.demo.pojo.View;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.sql.*;
import java.util.*;

import java.io.*;

public class ExcelFile {
    public static Connection oldConn;
    public static Connection newConn;
    public static InputStream is;
    public static Properties pro;
    public static String fileName;
    public static String filePath;


//    public static String username;
//    public static PreparedStatement sts = null;
//    public static ResultSet rs = null;
//    新增字段
//    public static HashMap<String,List<String>> addMap = null;
//    删除字段
//    public static HashMap<String,List<String>> delMap = null;

    public static void main(String[] args) throws Exception {
        is = ExcelFile.class.getClassLoader().getResourceAsStream("database.properties");
//        is = ExcelFile.class.getClassLoader().getResourceAsStream("");
        File file = new File("");
        String filePath = file.getCanonicalPath();
        System.out.println(filePath);


        System.out.println(is);
        pro = new Properties();
        pro.load(is);
//        分别读取旧数据库以及新数据库
        readOldDatabase(pro);
        readNewDatabase(pro);
        List<View> views = ComparView();
       readXlsConfig();
//       导出excel
        exportToXls(views);

    }

    private static List<View> ComparView() throws Exception {
        //        比对新旧视图的差异
        SqlBuilder sqlBuilder = new SqlBuilder();
        View  view ;
        List<View>  views = new ArrayList<View>();
//        System.out.println(oldConn);
//        System.out.println(newConn);
//        查询对应数据库下所有的视图，此处只针对mysql,  oracle后续再处理，下列分别是旧数据库以及新数据库的字段名
        List<String> oldViewNames = sqlBuilder.selectOldViews(oldConn);
        System.out.println("共需要对比"+oldViewNames.size()+"张视图");
//        List<String> newViewNames = selectNewViews();

        //查询新老视图下的所有字段
        List<String> oldViewColumnNames = Collections.EMPTY_LIST;
        List<String> newViewColumnNames = Collections.EMPTY_LIST;

//      每个视图新增的字段
        List<String> addList = Collections.EMPTY_LIST;;
        // 每个视图删除的字段
        List<String> delList = Collections.EMPTY_LIST;



        StringBuffer add_col;
        StringBuffer del_col;
        int index = 0;
//        获取旧视图所有字段名称
        for(String viewName : oldViewNames){
            view = new View();
            add_col = new StringBuffer(" ");
            del_col = new StringBuffer(" ");

            oldViewColumnNames = sqlBuilder.selectOldViewsColumnName(viewName,oldConn);
            newViewColumnNames = sqlBuilder.selectNewViewsColumnName(viewName,newConn);

//            使用日志输出
//            System.out.println("视图名称+字段"+viewName+oldViewColumnNames);
//            System.out.println("新视图名称+字段"+viewName+newViewColumnNames);

            Boolean flag = true;
//            先遍历新试图所有字段，此逻辑表示新试图新增的字段
            for(String newColumn : newViewColumnNames){
                for(String oldColumn : oldViewColumnNames){
//                    两个视图有相同的字段，不予考虑
                    if(oldColumn.equals(newColumn)){
                        flag = false;
                        break;
                    }

                }
                // 若flag=true;表示此字段为新增的（不然会走上面的continue）
                if(flag){
                    add_col.append(newColumn+",");
//                    addList.add(newColumn);
                }
                flag = true;

            }
            if(add_col.length()-1 > 0){
                add_col.deleteCharAt(add_col.length()-1);
            }


//            先遍历新旧试图所有字段，此逻辑表示新试图新删除掉的字段
            for(String oldColumn : oldViewColumnNames){
                for(String newColumn : newViewColumnNames){
//                    两个视图有相同的字段，不予考虑
                    if(oldColumn.equals(newColumn)){
                        flag = false;
                        break;
                    }

                }
                // 若flag=true;表示此字段为新增的（不然会走上面的continue）
                if(flag){
//                    delList.add(oldColumn);
                    del_col.append(oldColumn+",");
                }

                flag = true;


            }
            if(del_col.length() > 0){
                del_col.deleteCharAt(del_col.length()-1);
            }


            view.setId(index++);
            view.setViewName(viewName);
            view.setAddColumn(add_col.toString());
            view.setDelColumn(del_col.toString());



            views.add(view);
        }
        return views;

    }


    //    读取数据库的配置文件
    public static void readOldDatabase(Properties pro) throws Exception{
        //获取集合当中的键值对
        String driverClass = pro.getProperty("oldDriverClass");
        String url = pro.getProperty("oldUrl");
        String username = pro.getProperty("oldUsername");
        String password = pro.getProperty("oldPassword");

        Class.forName(driverClass);
        oldConn = DriverManager.getConnection(url, username, password);
    }

    public static void readNewDatabase(Properties pro) throws Exception{
        //获取集合当中的键值对
        String driverClass = pro.getProperty("newDriverClass");
        String url = pro.getProperty("newUrl");
        String username = pro.getProperty("newUsername");
        String password = pro.getProperty("newPassword");

        Class.forName(driverClass);
        newConn = DriverManager.getConnection(url, username, password);
    }

//    获取视图保存路径以及视图名称
    public static void readXlsConfig() throws UnsupportedEncodingException {
//        防止中文乱码
        filePath = new String(pro.getProperty("filePath").getBytes("ISO-8859-1"),"gbk").replace("\"", "");
        fileName = new String(pro.getProperty("fileName").getBytes("ISO-8859-1"),"gbk").replace("\"", "");

    }

    public static void exportToXls(List<View> views){
        if(views.size()<= 0){
            //打印日志
            System.out.println("没有差异的视图");
            return ;
        }

        HSSFWorkbook wb = new HSSFWorkbook();
        //创建第一张表
        HSSFSheet sheet = wb.createSheet("视图比对表");
        //创建第一行
        HSSFRow row0 = sheet.createRow(0);
        //创建第一个单元格,依次类推
        HSSFCell cell0 = row0.createCell(0);
        cell0.setCellValue("id");

        HSSFCell cell1 = row0.createCell(1);
        cell1.setCellValue("差异试图名称");

        HSSFCell cell2 = row0.createCell(2);
        cell2.setCellValue("新增字段");

        HSSFCell cell3 = row0.createCell(3);
        cell3.setCellValue("删除字段");

        HSSFCell cell4 = row0.createCell(4);
        cell4.setCellValue("相关需求");

        HSSFRow rowi = null;
        HSSFCell createCell = null;

        for (int i = 0; i < views.size(); i++) {
            //创建第二行，填充内容
            rowi = sheet.createRow(i+1);

            createCell = rowi.createCell(0);//获取第一个单元格
            createCell.setCellValue(views.get(i).getId());

//            试图名称
            createCell = rowi.createCell(1);//获取第三个单元格
            createCell.setCellValue(views.get(i).getViewName());


            // 新增字段
            createCell = rowi.createCell(2);//获取第三个单元格
            createCell.setCellValue(views.get(i).getAddColumn());

//            删除字段
            createCell = rowi.createCell(3);//获取第三个单元格
            createCell.setCellValue(views.get(i).getDelColumn());
//            相关需求
            createCell = rowi.createCell(4);//获取第二个单元格
            createCell.setCellValue(views.get(i).getNeeds());

        }
        //写出
        //这个流从response获取，再配置响应头信息就可以实现下载；
        OutputStream out = null;
        try {
            out = new FileOutputStream(new File(filePath,fileName));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        try {
            wb.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
