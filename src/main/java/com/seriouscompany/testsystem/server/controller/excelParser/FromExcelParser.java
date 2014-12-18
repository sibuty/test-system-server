//package com.seriouscompany.testsystem.server.controller.excelParser;
//
//import com.seriouscompany.testsystem.server.entities.test.Question;
//import com.seriouscompany.testsystem.server.entities.Test;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Iterator;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//
///**
// *
// * @author Igor
// */
//public final class FromExcelParser {
//
//    private FromExcelParser() {
//    }
//
//    public static Test parseTest(String name) {
//
//        String theme;
//        Test test = new Test();
//        InputStream in = null;
//        HSSFWorkbook wb = null;
//
//        try {
//            in = new FileInputStream(name);
//            wb = new HSSFWorkbook(in);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        boolean isThem = true;
//        Sheet sheet = wb.getSheetAt(0);
//        Iterator<Row> it = sheet.iterator();
//        Cell cell;
//        while (it.hasNext()) {
//            Row row = it.next();
//            Question question = new Question();
//            int position = 0;
//            Iterator<Cell> cells = row.iterator();
//            while (cells.hasNext()) {
//                cell = cells.next();
//                if (isThem) {
//                    test.setTheme(cell.getStringCellValue());
//                } else {
//                    switch (position) {
//                        case 0: {
//                            question.setName(cell.getStringCellValue());
//                            break;
//                        }
//                        case 1: {
//                            question.setAnswer(cell.getStringCellValue());
//                            break;
//                        }
//                        default: {
//                            question.addIncorrectAnswer(cell.getStringCellValue());
//                            break;
//                        }
//                    }
//                    position++;
//                }
//            }
//            if (isThem) {
//                isThem = false;
//            } else {
//                test.addQuestion(question);
//            }
//        }
//        return test;
//    }
//
//}
