package com.demo.WiriteToExcel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
/**
 * A very simple program that writes some data to an Excel file
 * using the Apache POI library.
 * @author www.codejava.net
 *
 */
public class SimpleExcelWriterExample {
 
    public static void writetoExcel( Map<String, Map<String, String>> data) throws IOException {
    	//Blank workbook
    	  //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook(); 
         
        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Duplicate Mobile numbers");
        
          
        //Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Mobile_No");
        headerRow.createCell(1).setCellValue("Name");
        headerRow.createCell(2).setCellValue("City");
        int rownum = 1;
        for (String key : keyset)
        {
            Row row = sheet.createRow(rownum++);
             Map<String, String> map = data.get(key);
             Set<String> keySet2 = map.keySet();
             
            int cellnum = 0;
            for (String obj : keySet2)
            {
               Cell cell = row.createCell(cellnum++);
               if(obj instanceof String)
                    cell.setCellValue((String)map.get(obj));
                
            }
        }
        try
        {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("DuplicateMobileNumberList.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("DuplicateMobileNumberList.xlsx written successfully on disk.");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }}