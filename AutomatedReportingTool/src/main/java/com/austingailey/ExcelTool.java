package com.austingailey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.File;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.apache.poi.ss.usermodel.Sheet;

public class ExcelTool {
    protected Logger log = LoggerFactory.getLogger(ExcelTool.class);
    protected FileOutputStream out;
    protected String outputPath;
    protected Workbook wb;

    public ExcelTool(){}

    public void createWorkbook(String filePath){
        outputPath = filePath;
        openFileOutputStream(false);
        wb = new XSSFWorkbook();
        wb.createSheet("Default");
        closeFileOutputStream();
    }

    public void openExistingWorkbook(String filePath){
        try{
            FileInputStream inp = new FileInputStream(filePath);
            outputPath = filePath;
            wb = WorkbookFactory.create(inp);
        }catch(Exception e){
            createWorkbook(filePath);
            log.error("Couldn't get existing WorkBook: " + e);
        }
    }

    public Workbook getWorkbook(){
        return wb;
    }

    public void copyWorkbook(Workbook wbToCopy){
        openFileOutputStream(false);
        wb = wbToCopy;
        closeFileOutputStream();
    }

    public void createSheet(String sheetName){
        openFileOutputStream(false);
        wb.createSheet(sheetName);
        closeFileOutputStream();
    }

    public void openFileOutputStream(boolean append){
        try{
            new File(outputPath);
            out = new FileOutputStream(outputPath);
        }catch(Exception e){
            log.error("Error opening file at: " + outputPath + " " +e);
        }
    }

    public void closeFileOutputStream(){
        try{
            wb.write(out);
            out.close();
        }catch(Exception e){
            log.error("Error writing to file: " + e);
        }
    }

}