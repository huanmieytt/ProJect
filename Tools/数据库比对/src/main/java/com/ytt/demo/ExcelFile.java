package com.ytt.demo;

import com.ytt.demo.pojo.View;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExcelFile {
    public static void main(String[] args) {
//        路径和文件名称可配置在xml文件中
        String FilePath = "C:/Users/ytt/Desktop";
        String clsName = "视图比对差异化文件.xls";
        SAXReader reader = new SAXReader();


        List<View> viewLists = new ArrayList<View>();
        View view1 = new View("1","v_s_dv_voc","struc1","00001");
        View view2 = new View("2","v_b_dai_item","struc2","00002");
        View view3 = new View("3","v_b_dai_item3","struc3","00003");
        viewLists.add(view1);
        viewLists.add(view2);
        viewLists.add(view3);

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
        cell2.setCellValue("结构变更");

        HSSFCell cell3 = row0.createCell(3);
        cell3.setCellValue("相关需求");

        HSSFRow rowi = null;
        HSSFCell createCell = null;

        for (int i = 0; i < viewLists.size(); i++) {
            //创建第二行，填充内容
            rowi = sheet.createRow(i+1);

            createCell = rowi.createCell(0);//获取第一个单元格
            createCell.setCellValue(viewLists.get(i).getId());

//            试图名称
            createCell = rowi.createCell(1);//获取第三个单元格
            createCell.setCellValue(viewLists.get(i).getViewName());

            //            修改的字段名
            createCell = rowi.createCell(2);//获取第三个单元格
            createCell.setCellValue(viewLists.get(i).getStrucChange());

//            相关需求
            createCell = rowi.createCell(3);//获取第二个单元格
            createCell.setCellValue(viewLists.get(i).getNeeds());

        }
        //写出
        //这个流从response获取，再配置响应头信息就可以实现下载；
        OutputStream out = null;
        try {
            out = new FileOutputStream(new File(FilePath,clsName));
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
