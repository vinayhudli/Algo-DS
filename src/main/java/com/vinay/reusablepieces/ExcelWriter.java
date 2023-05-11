package com.vinay.reusablepieces;

import lombok.Builder;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Builder
public class ExcelWriter {

    private final List<String> headers;
    private final String fontName;
    private final short fontHeight;
    @Builder.Default
    private final String fileName = "report.xlsx" ;
    private final boolean appendSheetToFile ;


    private Path createFile() throws IOException {
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        String fileLocation = path.substring(0, path.length() - 1) + fileName;
        Path filePath = Path.of(fileLocation);
        if (appendSheetToFile){
            if (Files.exists(filePath))
                return filePath;
        }else{
            Files.deleteIfExists(filePath);
        }
        return Files.createFile(filePath);
    }

    private void writeHeaders(Workbook workbook, Optional<String> sheetName){
        Sheet sheet = sheetName.isPresent()? workbook.createSheet(sheetName.get()): workbook.createSheet();
        CellStyle headerStyle = workbook.createCellStyle();
        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName(fontName);
        font.setFontHeightInPoints(fontHeight);
        font.setBold(true);
        headerStyle.setFont(font);

        Row header = sheet.createRow(0);
        for (int i = 0; i < headers.size(); i++) {
            Cell headerCell = header.createCell(i);
            headerCell.setCellValue(headers.get(i));
            headerCell.setCellStyle(headerStyle);
        }
    }

    private void writeBody(Workbook workbook, List<ExcelRow> data, Optional<String> sheetName){
        Sheet sheet = sheetName.isPresent()? workbook.getSheet(sheetName.get()) : workbook.getSheetAt(workbook.getActiveSheetIndex());
        System.out.println(sheet.getSheetName());
        int rowNum = 0;
        for (ExcelRow entry:data){
            Row row = sheet.createRow(++rowNum);
            List<Object> values = entry.getValue();
            int colNum = 0;
            for (Object val:values){
                Cell cell = row.createCell(colNum++);
                setCellValue(cell, val);
            }
        }
    }

    private void setCellValue(Cell cell, Object value){
        if (value instanceof Double val)
            cell.setCellValue(val);
        else if (value instanceof Date val)
            cell.setCellValue(val);
        else if (value instanceof Integer val)
            cell.setCellValue(val);
        else
            cell.setCellValue(value.toString());
    }

    public File writeToFile(List<ExcelRow> data, Optional<String> sheetName) throws IOException, InvalidFormatException {
        File file = new File(String.valueOf(createFile()));
        try(
                Workbook workbook = appendSheetToFile ? new XSSFWorkbook(file): new XSSFWorkbook();
                FileOutputStream fileOutputStream = new FileOutputStream(fileName+".new")){
            writeHeaders(workbook, sheetName);
            writeBody(workbook, data, sheetName);
            workbook.write(fileOutputStream);
            Path path = Paths.get(fileName);
            Files.delete(path);
            Files.move(Paths.get(fileName + ".new"), path);
            return new File(fileName);
        }
    }

    public byte[] getExcelDataAsBytes(List<ExcelRow> data) throws IOException {
        try(Workbook workbook = new XSSFWorkbook();
            ByteArrayOutputStream bos = new ByteArrayOutputStream()){
            writeHeaders(workbook, Optional.empty());
            writeBody(workbook, data, Optional.empty());
            workbook.write(bos);
            return bos.toByteArray();
        }
    }

    public File writeToFile(byte[] data) throws IOException {
        Path path = createFile();
        try(
                ByteArrayInputStream bf = new ByteArrayInputStream(data);
                Workbook workbook = new XSSFWorkbook(bf);
                BufferedOutputStream b = new BufferedOutputStream(new FileOutputStream(path.toString()))
        ){
            workbook.write(b);
            return path.toFile();
        }
    }

    public static class ExcelRow{
        List<Object> value;

        public ExcelRow(List<Object> value) {
            this.value = value;
        }

        public List<Object> getValue() {
            return value;
        }

        public void setValue(List<Object> value) {
            this.value = value;
        }
    }
}

