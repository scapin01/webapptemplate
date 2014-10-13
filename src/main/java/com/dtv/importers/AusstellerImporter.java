package com.dtv.importers;

import com.dtv.models.Aussteller;
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
 * Time: 15:09
 * To change this template use File | Settings | File Templates.
 */
public class AusstellerImporter extends AbstractJob{

    private static final Logger logger = Logger.getLogger(ParticipantImporter.class.getName());

    public void start(){

        /*String quey = "Florian";
        long start = System.currentTimeMillis();
        for(int i=0;i<500;i++){
            Query<Participant> q=morphium.createQueryFor(Participant.class);
            query = query.toLowerCase();
            q=q.or(q.q().f("last_name").matches(".*"+query+".*"),q.q().f("address1").matches(".*"+query+".*"),q.q().f("address1").matches(".*"+query+".*"));
            q.asList();
        }
        long stop1 = System.currentTimeMillis();
        logger.info("Time q1:"+ (stop1 - start)/1000 +" s");
        for(int i=0;i<500;i++){
            Query<Participant> q=morphium.createQueryFor(Participant.class);
            query = query.toLowerCase();
            q=q.or(q.q().f("last_name").matches(query),q.q().f("address1").matches(query),q.q().f("address1").matches(query));
            q.asList();
        }
        long stop2 = System.currentTimeMillis();
        logger.info("Time q2:"+ (stop2 - stop1)/1000 +" s");*/

        List<Aussteller> ausstellers = new ArrayList<Aussteller>();

        try {

            System.out.println("Working Directory = " +
                    System.getProperty("user.dir"));
            File fileInput = new File("docs/aussteller.xlsx");

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
                    Aussteller aussteller = new Aussteller();
                    int cellIndex = 0;
                    while (cellIterator.hasNext())
                    {
                        cell = cellIterator.next();

                        switch (cell.getCellType())
                        {
                            case Cell.CELL_TYPE_NUMERIC:

                                switch (cellIndex){
                                    case 0:
                                        Double d = cell.getNumericCellValue();
                                        aussteller.setStandNr(String.valueOf(d.intValue()));
                                        break;
                                }

                                break;
                            case Cell.CELL_TYPE_STRING:
                                switch (cellIndex){

                                    case 1:
                                        aussteller.setOrganization(cell.getStringCellValue());
                                        break;
                                    case 2:
                                        aussteller.setWebsite(cell.getStringCellValue());
                                        break;

                                    case 3:
                                        aussteller.setLogo(cell.getStringCellValue());
                                        break;
                                }

                                System.out.println(cell.getStringCellValue());
                                break;

                            default:
                                System.out.println(cell);

                        }

                        cellIndex ++;
                    }

                    if(StringUtils.isNotEmpty(aussteller.getOrganization())){
                        ausstellers.add(aussteller);

                    }
                }
                rowIndex ++;
            }
        }
        catch (Exception e)
        {
            System.err.println("Exception :" + e.getMessage());
        }

        if(ausstellers.size()>0){
            morphium.clearCollection(Aussteller.class);
            for(Aussteller p : ausstellers){
                morphium.store(p);
            }
        }

        String b = "";
    }


}
