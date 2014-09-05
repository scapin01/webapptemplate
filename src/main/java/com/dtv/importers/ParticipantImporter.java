package com.dtv.importers;

import com.dtv.models.Participant;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: florianbessiere
 * Date: 03.09.14
 * Time: 11:53
 * To change this template use File | Settings | File Templates.
 */
public class ParticipantImporter extends AbstractJob{


    private static final Logger logger = Logger.getLogger(ParticipantImporter.class.getName());

    public void start(){

        List<Participant> participants = new ArrayList<Participant>();

        try {

            System.out.println("Working Directory = " +
                    System.getProperty("user.dir"));
            File fileInput = new File("docs/teilnehmer.xlsx");

            // Get the workbook instance for XLSX file
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(fileInput));
            // Get first sheet from the workbook
            XSSFSheet sheet = wb.getSheetAt(0);
            Row row;
            Cell cell;
            // Iterate through each rows from first sheet
            Iterator<Row> rowIterator = sheet.iterator();

            int rowIndex = 0;

            while (rowIterator.hasNext())
            {
                row = rowIterator.next();

                // For each row, iterate through each columns
                if(rowIndex>0){
                    Iterator<Cell> cellIterator = row.cellIterator();
                    Participant participant = new Participant();
                    int cellIndex = 0;
                    while (cellIterator.hasNext())
                    {
                        cell = cellIterator.next();



                        switch (cell.getCellType())
                        {
                            case Cell.CELL_TYPE_STRING:
                                switch (cell.getColumnIndex()){
                                    case 0:
                                        participant.setTitle(cell.getStringCellValue());
                                        break;
                                    case 1:
                                        participant.setPosition(cell.getStringCellValue());
                                        break;
                                    case 2:
                                        participant.setFirstName(cell.getStringCellValue());
                                        break;
                                    case 3:
                                        participant.setLastName(cell.getStringCellValue());
                                        break;
                                    case 4:
                                        participant.setXing(cell.getStringCellValue());
                                        break;
                                    case 5:
                                        participant.setAddress1(cell.getStringCellValue());
                                        break;
                                    case 6:

                                        if(StringUtils.isNotEmpty(cell.getStringCellValue())){
                                            if(StringUtils.isNotEmpty(participant.getAddress1())){
                                                participant.setAddress1(participant.getAddress1()+" "+cell.getStringCellValue());
                                            }else{
                                                participant.setAddress1(cell.getStringCellValue());
                                            }
                                        }
                                        break;
                                    case 8:
                                        participant.setCity(cell.getStringCellValue());
                                        break;

                                }

                                System.out.println(cell.getStringCellValue());
                                break;

                            default:
                                System.out.println(cell);

                        }

                        cellIndex ++;
                    }

                    participants.add(participant);
                }
                rowIndex ++;
            }
        }
        catch (Exception e)
        {
            System.err.println("Exception :" + e.getMessage());
        }

        if(participants.size()>25){
            morphium.clearCollection(Participant.class);
            for(Participant p : participants){
                morphium.store(p);

            }

        }

        String b = "";
    }


}
