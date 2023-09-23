package com.che.demo.once;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel {

    /**
     * 读取表格数据
     *
     * @param sheetName
     * @return
     * @throws IOException
     */
    public static List<String> getCarData(String sheetName)throws IOException{
        // 指定excel文件，创建缓存输入流
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("D:\\liumingyao\\study\\projects\\idea_project\\demo\\file\\车型名称映射.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        // 选择要处理的sheet名称
        XSSFSheet sheet = workbook.getSheet(sheetName);
        List<String> sheetAData = new ArrayList<>();
        // 迭代遍历sheet每一行
        for (int rowNum = 1; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {
                XSSFRow row = sheet.getRow(rowNum);
                String carName = row.getCell(0).getStringCellValue();
                sheetAData.add(carName);
            }
        workbook.close();
        inputStream.close();
        return sheetAData;
    }
}

