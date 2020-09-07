package com.austingailey;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import javax.activation.FileDataSource;

public class TestExcelTool {
    
    @Test
    public void testExcelToolConsctructor(){
        ExcelTool excelTool = new ExcelTool();
        assertNotNull(excelTool);
    }

    @Test
    public void testCreateWorkBook(){
        //create WB with custom name
        ExcelTool excelTool = new ExcelTool();
        String outputString = "src/test/resources/generatedResources/TestWB.xlsx";
        excelTool.createWorkBook(outputString);
        assertEquals("TestWB.xlsx",new FileDataSource(outputString).getName()); 
    }

    @Test
    public void testCreateWorkBookFromTemplate(){
        //create a WB from an existing WB
        
    }

    @Test
    public void testCreateSheet(){
        //create a new Sheet with a custom name
    }

    @Test
    public void testCreateSheetFromTemplate(){
        //create a SH from an existing SH
    }

    @Test
    public void addSheet(){
        //add a SH to a WB
    }

}