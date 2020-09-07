package com.austingailey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileOutputStream;
import java.io.File;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTool {
    protected Logger log = LoggerFactory.getLogger(EmailTool.class);
    protected FileOutputStream out;
    protected String outputPath;
    protected XSSFWorkbook wb;

    public ExcelTool(){}

    public void createWorkBook(String outputPathInput){
        outputPath = outputPathInput;
        openFileOutputStream(false);
        wb = new XSSFWorkbook();
        closeFileOutputStream();
    }

    public void openFileOutputStream(boolean append){
        try{
            if(!append){
                new File(outputPath);
            }
            out = new FileOutputStream(outputPath, append);
        }catch(Exception e){
            log.error("Error opening file" + e);
        }
    }

    public void closeFileOutputStream(){
        try{
            wb.write(out);
            out.close();
        }catch(Exception e){}
    }
}