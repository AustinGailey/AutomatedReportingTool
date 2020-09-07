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
    public void testCreateWorkbook(){
        ExcelTool excelTool = new ExcelTool();
        String outputString = "src/test/resources/generatedResources/TestWB.xlsx";
        excelTool.createWorkbook(outputString);
        assertEquals("TestWB.xlsx",new FileDataSource(outputString).getName()); 
    }

    @Test
    public void testCreateSheet(){
        //create a new Sheet with a custom name
        ExcelTool workbook = new ExcelTool();
        String inputPath = "src/test/resources/generatedResources/TestWB.xlsx";
        workbook.openExistingWorkbook(inputPath);
        workbook.createSheet("Test Sheet");
        assertEquals("Test Sheet", workbook.getWorkbook().getSheet("Test Sheet").getSheetName());
    }

    @Test
    public void testCreateWorkBookFromTemplate(){
        //create a WB from an existing WB
        ExcelTool existingWB = new ExcelTool();
        String inputPath = "src/test/resources/generatedResources/TestWB.xlsx";
        existingWB.openExistingWorkbook(inputPath);
        ExcelTool newWB = new ExcelTool();
        String outputPath = "src/test/resources/generatedResources/NewTestWB.xlsx";
        newWB.createWorkbook(outputPath);
        newWB.copyWorkbook(existingWB.getWorkbook());
        assertEquals(existingWB.getWorkbook(),newWB.getWorkbook());
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