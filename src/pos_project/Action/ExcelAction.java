/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_project.Action;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Properties;
import javax.swing.table.TableModel;
import jxl.CellView;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.write.*;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import pos_project.classes.Formats;

/**
 *
 * @author Cif3r
 */
public class ExcelAction {
    
    
    //Post dated checks
public static void createPostDatedChecksReportWXL(String file, TableModel model, String title, String name) throws WriteException{
        try {
             WritableWorkbook workbook = Workbook.createWorkbook(new File(file));
//            createExcelSheet(model, title, workbook);
//            for(int i = 0; i<4; i++){
//                switch(i){
//
//                    
//                    case 1 : createinWSheet(workbook,  "Absences Per Week Analysis", inabsentWVal, inabsentWD, "Absences Per Week", 1);
//                           break;
//                    case 2 : createinWSheet(workbook,  "Late Per Week Analysis", inlateWVal, inlateWD, "Late Per Week", 2);
//                            break;
//                    case 3 : createinWSheet(workbook,  "Penalties Per Week Analysis", inpenalWVal, inpenalWD, "Penalties Per Week", 3);
//                            break;
//                    default : 
//                            createinWSheet(workbook,  "Attendance Per Week Analysis", inattendWVal, inattendWD, "Attendance Per Week", 0);
//                           break;
//                }
//            }
            
             try {
            WritableSheet sheet = workbook.createSheet(title, 0);
            
//             WritableCellFormat tableFormat = new WritableCellFormat();
//            tableFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
               int rowCount = 0;
            sheet = setExcelHeader(sheet, rowCount);
            
            rowCount = sheet.getRows();
            rowCount++;
             WritableCellFormat tableFormat = new WritableCellFormat();
            tableFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
             WritableCellFormat tableFormatRightALign = new WritableCellFormat();
            tableFormatRightALign.setBorder(Border.ALL, BorderLineStyle.THIN);
           tableFormatRightALign.setAlignment(Alignment.RIGHT);
            
           rowCount++;
//            sheet.mergeCells(0, 1, 1, 1);
//            sheet.mergeCells(0, 2, 3, 2);
//             Label titleLabel = new Label(0,0, title);
//            sheet.addCell(titleLabel);
            if(title.equals("Inventory Report") || title.equals("Accounts Payable Summary")){
                Label productLabel = new Label(0,rowCount, "Supplier Name: "+name);
                sheet.addCell(productLabel);
//                Label productValue = new Label(1,1, name);
//                sheet.addCell(productValue);
            } else {
                Label productLabel = new Label(0,rowCount, "Customer Name: "+ name);
                sheet.addCell(productLabel);
//                Label productValue = new Label(1,1, name);
//                sheet.addCell(productValue);
            }
            rowCount+=2;
            
            for(int i = 0; i<model.getColumnCount();i++){
                  Label label = new Label(i,rowCount, model.getColumnName(i),tableFormat);                    
                  sheet.addCell(label);
                }
            rowCount++;
            for( int i =0; i<model.getRowCount(); i++){
                for(int j = 0; j<model.getColumnCount();j++){
                  Label label = new Label(j, rowCount, model.getValueAt(i, j).toString(),tableFormat);                    
                  sheet.addCell(label);
                }
                rowCount++;
            }
            
            sheet = setAutoFit(sheet);

        } catch (Exception ex) {
            ex.printStackTrace();
//            Logger.getLogger(talent_bunseki.class.getName()).log(Level.SEVERE, null, ex);
        }
            workbook.write();
            workbook.close();

        } catch (IOException ex) {
            ex.printStackTrace();
//            Logger.getLogger(talent_bunseki.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
 public static void createAccountsSummaryWXL(String file, TableModel model, String title, String name) throws WriteException{
        try {
             WritableWorkbook workbook = Workbook.createWorkbook(new File(file));
            
             try {
                 
            WritableSheet sheet = workbook.createSheet(title, 0);
             int rowCount = 0;
            sheet = setExcelHeader(sheet, rowCount);
            
            rowCount = sheet.getRows();
            rowCount++;
//            sheet.mergeCells(0, rowCount, 1, rowCount);
//            sheet.mergeCells(0, 2, 3, 2);
             WritableCellFormat tableFormat = new WritableCellFormat();
            tableFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
             WritableCellFormat tableFormatRightALign = new WritableCellFormat();
            tableFormatRightALign.setBorder(Border.ALL, BorderLineStyle.THIN);
           tableFormatRightALign.setAlignment(Alignment.RIGHT);
            
            
//             WritableCellFormat tableFormat = new WritableCellFormat();
//            tableFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
//            int rowCount =0;
            
            
//            sheet.mergeCells(0, rowCount, 1, rowCount);
            if( title.equals("Accounts Payable Summary")){
                Label productLabel = new Label(0,rowCount, "Supplier Name: "+name);
                sheet.addCell(productLabel);
            } else {
                Label productLabel = new Label(0,rowCount, "Customer Name: "+ name);
                sheet.addCell(productLabel);
            }
            rowCount += 2;
            for(int i = 0; i<model.getColumnCount();i++){
                  Label label = new Label(i,rowCount, model.getColumnName(i),tableFormat);                    
                  sheet.addCell(label);
                }
            rowCount++;
            for( int i =0; i<model.getRowCount(); i++){
                for(int j = 0; j<model.getColumnCount();j++){
                  Label label;  
                  if(j == 2 || j == 3){
                      label = new Label(j, rowCount, model.getValueAt(i, j).toString(),tableFormatRightALign);                    
                  } else {
                      label = new Label(j, rowCount, model.getValueAt(i, j).toString(),tableFormat);                    
                  }
                   
                  sheet.addCell(label);
                }
                rowCount++;
            }
            
            sheet = setAutoFit(sheet);

        } catch (Exception ex) {
            ex.printStackTrace();
//            Logger.getLogger(talent_bunseki.class.getName()).log(Level.SEVERE, null, ex);
        }
            workbook.write();
            workbook.close();

        } catch (IOException ex) {
            ex.printStackTrace();
//            Logger.getLogger(talent_bunseki.class.getName()).log(Level.SEVERE, null, ex);
        }
}
 
 public static void createAccountsAgingWXL(String file, TableModel model, String title, String name) throws WriteException{
        try {
             WritableWorkbook workbook = Workbook.createWorkbook(new File(file));
            
             try {
                 
            WritableSheet sheet = workbook.createSheet(title, 0);
             int rowCount = 0;
            sheet = setExcelHeader(sheet, rowCount);
            
            rowCount = sheet.getRows();
            rowCount++;
//            sheet.mergeCells(0, rowCount, 1, rowCount);
//            sheet.mergeCells(0, 2, 3, 2);
             WritableCellFormat tableFormat = new WritableCellFormat();
            tableFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
             WritableCellFormat tableFormatRightALign = new WritableCellFormat();
            tableFormatRightALign.setBorder(Border.ALL, BorderLineStyle.THIN);
           tableFormatRightALign.setAlignment(Alignment.RIGHT);
            
            
//             WritableCellFormat tableFormat = new WritableCellFormat();
//            tableFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
//            int rowCount =0;
            
            
//            sheet.mergeCells(0, rowCount, 1, rowCount);
            if( title.equals("Accounts Payable Aging")){
                Label productLabel = new Label(0,rowCount, "Supplier Name: "+name);
                sheet.addCell(productLabel);
            } else {
                Label productLabel = new Label(0,rowCount, "Customer Name: "+ name);
                sheet.addCell(productLabel);
            }
            rowCount += 2;
            for(int i = 0; i<model.getColumnCount();i++){
                  Label label = new Label(i,rowCount, model.getColumnName(i),tableFormat);                    
                  sheet.addCell(label);
                }
            rowCount++;
            for( int i =0; i<model.getRowCount(); i++){
                for(int j = 0; j<model.getColumnCount();j++){
                  Label label;  
                  if(j == 0 || j == 1){
                      label = new Label(j, rowCount, model.getValueAt(i, j).toString(),tableFormat);                    
                  } else {
                      label = new Label(j, rowCount, model.getValueAt(i, j).toString(),tableFormatRightALign);                    
                      
                  }
                   
                  sheet.addCell(label);
                }
                rowCount++;
            }
            
            sheet = setAutoFit(sheet);

        } catch (Exception ex) {
            ex.printStackTrace();
//            Logger.getLogger(talent_bunseki.class.getName()).log(Level.SEVERE, null, ex);
        }
            workbook.write();
            workbook.close();

        } catch (IOException ex) {
            ex.printStackTrace();
//            Logger.getLogger(talent_bunseki.class.getName()).log(Level.SEVERE, null, ex);
        }
}
 
 
 public static void createAccountsWXL(String file, TableModel model, String title) throws WriteException{
        try {
             WritableWorkbook workbook = Workbook.createWorkbook(new File(file));
            
             try {
                 
            WritableSheet sheet = workbook.createSheet(title, 0);
             int rowCount = 0;
            sheet = setExcelHeader(sheet, rowCount);
            
            rowCount = sheet.getRows();
//            rowCount++;
//            sheet.mergeCells(0, rowCount, 1, rowCount);
//            sheet.mergeCells(0, 2, 3, 2);
             WritableCellFormat tableFormat = new WritableCellFormat();
            tableFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
             WritableCellFormat tableFormatRightALign = new WritableCellFormat();
            tableFormatRightALign.setBorder(Border.ALL, BorderLineStyle.THIN);
           tableFormatRightALign.setAlignment(Alignment.RIGHT);
            
            
//             WritableCellFormat tableFormat = new WritableCellFormat();
//            tableFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
//            int rowCount =0;
            
            
//            sheet.mergeCells(0, rowCount, 1, rowCount);
            
            rowCount += 2;
            for(int i = 0; i<model.getColumnCount();i++){
                  Label label = new Label(i,rowCount, model.getColumnName(i),tableFormat);                    
                  sheet.addCell(label);
                }
            rowCount++;
            for( int i =0; i<model.getRowCount(); i++){
                for(int j = 0; j<model.getColumnCount();j++){
                  Label label;  
                  if( j == 4){
                      label = new Label(j, rowCount, model.getValueAt(i, j).toString(),tableFormatRightALign);                    
                  } else {
                      label = new Label(j, rowCount, model.getValueAt(i, j).toString(),tableFormat);                    
                  }
                   
                  sheet.addCell(label);
                }
                rowCount++;
            }
            
            sheet = setAutoFit(sheet);

        } catch (Exception ex) {
            ex.printStackTrace();
//            Logger.getLogger(talent_bunseki.class.getName()).log(Level.SEVERE, null, ex);
        }
            workbook.write();
            workbook.close();

        } catch (IOException ex) {
            ex.printStackTrace();
//            Logger.getLogger(talent_bunseki.class.getName()).log(Level.SEVERE, null, ex);
        }
}
 
 //Inventory Report
 public static void createInventoryXL(String file, TableModel model, String title, String name, String location) throws WriteException{
        try {
             WritableWorkbook workbook = Workbook.createWorkbook(new File(file));
//            createExcelSheet(model, title, workbook);
//            for(int i = 0; i<4; i++){
//                switch(i){
//
//                    
//                    case 1 : createinWSheet(workbook,  "Absences Per Week Analysis", inabsentWVal, inabsentWD, "Absences Per Week", 1);
//                           break;
//                    case 2 : createinWSheet(workbook,  "Late Per Week Analysis", inlateWVal, inlateWD, "Late Per Week", 2);
//                            break;
//                    case 3 : createinWSheet(workbook,  "Penalties Per Week Analysis", inpenalWVal, inpenalWD, "Penalties Per Week", 3);
//                            break;
//                    default : 
//                            createinWSheet(workbook,  "Attendance Per Week Analysis", inattendWVal, inattendWD, "Attendance Per Week", 0);
//                           break;
//                }
//            }
            
             try {
            WritableSheet sheet = workbook.createSheet(title, 0);
             
            
                int rowCount = 0;
            sheet = setExcelHeader(sheet, rowCount);
            
            rowCount = sheet.getRows();
//            rowCount++;
//            sheet.mergeCells(0, rowCount, 1, rowCount);
//            sheet.mergeCells(0, 2, 3, 2);
             WritableCellFormat tableFormat = new WritableCellFormat();
            tableFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
             WritableCellFormat tableFormatRightALign = new WritableCellFormat();
            tableFormatRightALign.setBorder(Border.ALL, BorderLineStyle.THIN);
           tableFormatRightALign.setAlignment(Alignment.RIGHT);
           
           
           rowCount++;
//            sheet.mergeCells(0, 2, 1, 2);
//           
//            sheet.mergeCells(0 , 3 , 1 , 3);

//            CellView cView = sheet.getRowView(0);
//            cView.setAutosize(true);
//            
            WritableCellFormat textFormat = new WritableCellFormat();
            textFormat.setWrap(true);
            
            
            
//            WritableCellFormat tableFormat = new WritableCellFormat();
//            tableFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
//            tableFormat.setWrap(false);
//            tableFormat.setOrientation(Orientation.HORIZONTAL);
//                tableFormat.setShrinkToFit(true);
            
             Label titleLabel = new Label(0,rowCount, title);
            sheet.addCell(titleLabel);
            rowCount++;
//            sheet.setRowView(0, cView);
            
                Label locationabel = new Label(0,rowCount, "Location: "+ location);
                sheet.addCell(locationabel);
//                sheet.setRowView(2, cView);
            rowCount++;
                
                Label productLabel = new Label(0, rowCount, "Supplier Name: "+name);
                sheet.addCell(productLabel);
//                sheet.setRowView(3, cView);

            
            for(int i = 0; i<model.getColumnCount();i++){
                  Label label = new Label(i,rowCount, model.getColumnName(i),tableFormat);                    
                  sheet.addCell(label);
                  
                }
            rowCount++;
//            sheet.setRowView(5, cView);
            for( int i =0; i<model.getRowCount(); i++){
                for(int j = 0; j<model.getColumnCount();j++){
                  Label label;
                  if(j == 1 ||j ==2){
                   label = new Label(j, rowCount, model.getValueAt(i, j).toString(),tableFormatRightALign);                       
                  } else {
                   label = new Label(j, rowCount, model.getValueAt(i, j).toString(),tableFormat);                    
                  }
                  sheet.addCell(label);
                }
//                sheet.setRowView(i+6, cView);
                rowCount++;
            }
            
            sheet = setAutoFit(sheet);

        } catch (Exception ex) {
            ex.printStackTrace();
//            Logger.getLogger(talent_bunseki.class.getName()).log(Level.SEVERE, null, ex);
        }
            workbook.write();
            workbook.close();

        } catch (IOException ex) {
            ex.printStackTrace();
//            Logger.getLogger(talent_bunseki.class.getName()).log(Level.SEVERE, null, ex);
        }
}
 
 
 
 public static void createPriceListXL(String file, TableModel model, String title, String name) throws WriteException{
        try {
             WritableWorkbook workbook = Workbook.createWorkbook(new File(file));
//            createExcelSheet(model, title, workbook);
//            for(int i = 0; i<4; i++){
//                switch(i){
//
//                    
//                    case 1 : createinWSheet(workbook,  "Absences Per Week Analysis", inabsentWVal, inabsentWD, "Absences Per Week", 1);
//                           break;
//                    case 2 : createinWSheet(workbook,  "Late Per Week Analysis", inlateWVal, inlateWD, "Late Per Week", 2);
//                            break;
//                    case 3 : createinWSheet(workbook,  "Penalties Per Week Analysis", inpenalWVal, inpenalWD, "Penalties Per Week", 3);
//                            break;
//                    default : 
//                            createinWSheet(workbook,  "Attendance Per Week Analysis", inattendWVal, inattendWD, "Attendance Per Week", 0);
//                           break;
//                }
//            }
            
             try {
            WritableSheet sheet = workbook.createSheet(title, 0);
             
            
                int rowCount = 0;
            sheet = setExcelHeader(sheet, rowCount);
            
            rowCount = sheet.getRows();
//            rowCount++;
//            sheet.mergeCells(0, rowCount, 1, rowCount);
//            sheet.mergeCells(0, 2, 3, 2);
                WritableFont f = new WritableFont(WritableFont.ARIAL, WritableFont.DEFAULT_POINT_SIZE,WritableFont.BOLD );
//                f.setBoldStyle();
                WritableCellFormat textFormatBold = new WritableCellFormat(f);
             WritableCellFormat tableFormat = new WritableCellFormat();
            tableFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
             WritableCellFormat tableFormatRightALign = new WritableCellFormat();
            tableFormatRightALign.setBorder(Border.ALL, BorderLineStyle.THIN);
           tableFormatRightALign.setAlignment(Alignment.RIGHT);
           
           
           rowCount++;
//            sheet.mergeCells(0, 2, 1, 2);
//           
//            sheet.mergeCells(0 , 3 , 1 , 3);

//            CellView cView = sheet.getRowView(0);
//            cView.setAutosize(true);
//            
            WritableCellFormat textFormat = new WritableCellFormat();
            textFormat.setWrap(true);
            
              Label titleLabel = new Label(0,rowCount, title, textFormatBold);
            sheet.addCell(titleLabel);
            rowCount++;

             Label productLabel = new Label(0, rowCount, "Supplier Name: "+name);
                sheet.addCell(productLabel);
//                sheet.setRowView(3, cView);
                
                rowCount++;
            
           
//                sheet.setRowView(2, cView);
            rowCount++;
                
               

            
            for(int i = 0; i<model.getColumnCount()-1;i++){
                  Label label = new Label(i,rowCount, model.getColumnName(i),tableFormat);                    
                  sheet.addCell(label);
                  
                }
            rowCount++;
//            sheet.setRowView(5, cView);
            for( int i =0; i<model.getRowCount(); i++){
                for(int j = 0; j<model.getColumnCount()-1;j++){
                  Label label;
                  if(j ==2){
                   label = new Label(j, rowCount, model.getValueAt(i, j).toString(),tableFormatRightALign);                       
                  } else {
                   label = new Label(j, rowCount, model.getValueAt(i, j).toString(),tableFormat);                    
                  }
                  sheet.addCell(label);
                }
//                sheet.setRowView(i+6, cView);
                rowCount++;
            }
            
            sheet = setAutoFit(sheet);

        } catch (Exception ex) {
            ex.printStackTrace();
//            Logger.getLogger(talent_bunseki.class.getName()).log(Level.SEVERE, null, ex);
        }
            workbook.write();
            workbook.close();

        } catch (IOException ex) {
            ex.printStackTrace();
//            Logger.getLogger(talent_bunseki.class.getName()).log(Level.SEVERE, null, ex);
        }
}
 
 public static void createAccountsLedgerWXL(String file, TableModel model, String title, String Name,String fromDate, String toDate) throws WriteException{
        try {
            WritableWorkbook workbook = Workbook.createWorkbook(new File(file));

            
            try{
            WritableSheet sheet = workbook.createSheet(title, 0);
            
            int rowCount = 0;
            sheet = setExcelHeader(sheet, rowCount);
            
            rowCount = sheet.getRows();
            rowCount++;
//            sheet.mergeCells(0, rowCount, 1, rowCount);
//            sheet.mergeCells(0, 2, 3, 2);
             WritableCellFormat tableFormat = new WritableCellFormat();
            tableFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
             WritableCellFormat tableFormatRightALign = new WritableCellFormat();
            tableFormatRightALign.setBorder(Border.ALL, BorderLineStyle.THIN);
           tableFormatRightALign.setAlignment(Alignment.RIGHT);
            
           if(title.equals("Accounts Payable")){ 
                Label productLabel = new Label(0,rowCount, "Supplier Name: "+ Name);
                sheet.addCell(productLabel);
            }else {
                Label productLabel = new Label(0,rowCount, "Customer Name: "+ Name);
                sheet.addCell(productLabel);
            }
           rowCount++;
//              sheet.mergeCells(0, rowCount, 3, rowCount);
            
            Label fromLabel = new Label(0,rowCount,"Date: "+ fromDate+" - "+toDate);
            sheet.addCell(fromLabel);
            rowCount+=2;
            
            for(int i = 0; i<model.getColumnCount();i++){
                  Label label = new Label(i,rowCount, model.getColumnName(i)+" ", tableFormat);                    
                  sheet.addCell(label);
                }
            rowCount++;
            for( int i =0; i<model.getRowCount(); i++){
                boolean isdetailed = false;
                boolean last = false;
                if((model.getValueAt(i, 0).toString().equals(" "))){
                        isdetailed = true;
                    }
                if(i ==  model.getRowCount()){
                    last = true;
                }
                for(int j = 0; j<model.getColumnCount();j++){
                    Label label;
                    String value = "-";
                    if(model.getValueAt(i, j) !=  null){
                        value = model.getValueAt(i, j).toString();
                    } 
                      if(j > 3){
                         label= new Label(j, i+rowCount, value, tableFormatRightALign);          
                     } else {
                          label = new Label(j, i+rowCount, value, tableFormat);          
                     }
                          sheet.addCell(label);
                   }
            }
            
//            sheet = setAutoFit(sheet);
        for(int x=0;x<sheet.getColumns();x++){
           CellView cell=sheet.getColumnView(x);
                cell.setAutosize(true);
                sheet.setColumnView(x, cell);
        }   
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
            workbook.write();
            workbook.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
}
 
 
 public static void createItemLedgerXL(String file, TableModel model, String title, String Name,String fromDate, String toDate, String location) throws WriteException{
        try {
            WritableWorkbook workbook = Workbook.createWorkbook(new File(file));
            try{
//            WritableCellFormat textFormat = new WritableCellFormat();
//            boolean isdetailed = false;
            WritableSheet sheet = workbook.createSheet(title, 0);
//             sheet.mergeCells(0, 2, 1, 2);
////           
//            sheet.mergeCells(0 , 3 , 1 , 3);
//            sheet.mergeCells(0 , 4 , 3 , 4);
            int rowCount = 0;
            sheet = setExcelHeader(sheet, rowCount);
            
            rowCount = sheet.getRows();
//            rowCount++;
//            sheet.mergeCells(0, rowCount, 1, rowCount);
//            sheet.mergeCells(0, 2, 3, 2);
             WritableCellFormat tableFormat = new WritableCellFormat();
            tableFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
             WritableCellFormat tableFormatRightALign = new WritableCellFormat();
            tableFormatRightALign.setBorder(Border.ALL, BorderLineStyle.THIN);
           tableFormatRightALign.setAlignment(Alignment.RIGHT);
            
            
//            CellView cView = sheet.getRowView(0);
//            cView.setAutosize(true);
           
           
            WritableCellFormat textFormat = new WritableCellFormat();
            textFormat.setWrap(true);
            
            rowCount+=2;
//            
//            WritableCellFormat tableFormat = new WritableCellFormat();
//            tableFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
            
            Label titleLabel = new Label(0,rowCount, title);
            sheet.addCell(titleLabel);
            
                        rowCount++;
            Label locLabel = new Label(0,rowCount, "Location: "+location);
                sheet.addCell(locLabel);
                
            
                Label productLabel = new Label(0,rowCount, "Product Name: "+ Name);
                sheet.addCell(productLabel);
                rowCount++;
            
            Label fromLabel = new Label(0,rowCount,"Date: "+fromDate+" - "+toDate);
            sheet.addCell(fromLabel);
            rowCount++;
            
            for(int i = 0; i<model.getColumnCount();i++){
                  Label label = new Label(i,rowCount, model.getColumnName(i),tableFormat);                    
                  sheet.addCell(label);
                }
                        rowCount++;
                        
            for( int i =0; i<model.getRowCount(); i++){
                for(int j = 0; j<model.getColumnCount();j++){
                    if(model.getValueAt(i, j)!= null){
                        Label label;
                        if( j >2){
                          label   = new Label(j, rowCount, model.getValueAt(i, j).toString(),tableFormatRightALign);            
                            } else{
                          label   = new Label(j, rowCount, model.getValueAt(i, j).toString(),tableFormat);      
                        }
                            sheet.addCell(label);

                    }
                }
                            rowCount++;
            }
            sheet = setAutoFit(sheet);
        } catch (Exception ex) {
            ex.printStackTrace();
//            Logger.getLogger(talent_bunseki.class.getName()).log(Level.SEVERE, null, ex);
        }
            workbook.write();
            workbook.close();

        } catch (IOException ex) {
            ex.printStackTrace();
//            Logger.getLogger(talent_bunseki.class.getName()).log(Level.SEVERE, null, ex);
        }
}
 
 
 //Detailed Sales customer/ Supplier
 public static void createDetailedWXL(String file, TableModel model, String title, String Name,String fromDate, String toDate) throws WriteException{
        try {
            WritableWorkbook workbook = Workbook.createWorkbook(new File(file));
             String curdir = System.getProperty("user.dir");
//                            Workbook workbook = Workbook.getWorkbook(new File(curdir+"\\src\\NCS\\Analysis\\Pslip.xls"));
//            Workbook template = Workbook.getWorkbook(new File(curdir+"\\ledgerFormatDate.xls"));
//            WritableWorkbook workbook = Workbook.createWorkbook(new File(file), template);
            
//            createExcelSheet(model, title, workbook);
//            for(int i = 0; i<4; i++){
//                switch(i){
//
//                    
//                    case 1 : createinWSheet(workbook,  "Absences Per Week Analysis", inabsentWVal, inabsentWD, "Absences Per Week", 1);
//                           break;
//                    case 2 : createinWSheet(workbook,  "Late Per Week Analysis", inlateWVal, inlateWD, "Late Per Week", 2);
//                            break;
//                    case 3 : createinWSheet(workbook,  "Penalties Per Week Analysis", inpenalWVal, inpenalWD, "Penalties Per Week", 3);
//                            break;
//                    default : 
//                            createinWSheet(workbook,  "Attendance Per Week Analysis", inattendWVal, inattendWD, "Attendance Per Week", 0);
//                           break;
//                }
//            }
            
            try{
                
//            WritableCellFormat textFormat = new WritableCellFormat();
//            textFormat.setWrap(true);
            
            
            
//            WritableCellFormat tableFormat = new WritableCellFormat();
//            tableFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
//            textFormat.setWrap(true);
//            boolean isdetailed = false;
            WritableSheet sheet = workbook.createSheet(title, 0);
             int rowCount = 0;
            sheet = setExcelHeader(sheet, rowCount);
            
            rowCount = sheet.getRows();
//            rowCount++;
//            sheet.mergeCells(0, rowCount, 1, rowCount);
//            sheet.mergeCells(0, 2, 3, 2);
             WritableCellFormat tableFormat = new WritableCellFormat();
            tableFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
             WritableCellFormat tableFormatRightALign = new WritableCellFormat();
            tableFormatRightALign.setBorder(Border.ALL, BorderLineStyle.THIN);
           tableFormatRightALign.setAlignment(Alignment.RIGHT);
            
//            sheet.mergeCells(0, 1, 1, 1);
//            sheet.mergeCells(0, 2, 1, 2);
//            sheet.mergeCells(2 , 2 , 3 , 2);
//            sheet.mergeCells(0 , 2 , 3 , 2);
//            WritableSheet sheet = (WritableSheet) workbook.getSheet(0);
//            sheet.setName(title);
            
//            WritableCell mergedText = (WritableCell) sheet.getCell(0, 2);
            
//            WritableCell mergedDate = (WritableCell) sheet.getCell(0, 3);
            
//            WritableCellFormat mergedFormat = new WritableCellFormat(mergedText.getCellFormat());
//            WritableCellFormat mergedDateFormat = new WritableCellFormat(mergedDate.getCellFormat());
            
            WritableCellFormat textFormat = new WritableCellFormat();
            textFormat.setWrap(true);
            
            
            
//            WritableCellFormat tableFormat = new WritableCellFormat();
//            tableFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
//            textFormat.setWrap(true);
            rowCount++;
            Label titleLabel = new Label(0,rowCount, title);
            sheet.addCell(titleLabel);
            rowCount++;
            if(title.equals("Item Ledger")){
                Label productLabel = new Label(0,rowCount, "Product Name:");
                sheet.addCell(productLabel);
                Label productValue = new Label(1,rowCount, Name);
                sheet.addCell(productValue);
            } else {
                Label productLabel = new Label(0,rowCount, "Client Name: "+Name);
                sheet.addCell(productLabel);
//                Label productValue = new Label(1,1, Name);
//                sheet.addCell(productValue);
            }
            rowCount++;
            Label fromLabel = new Label(0,rowCount,"Date: "+fromDate+" - "+toDate);
            sheet.addCell(fromLabel);
            rowCount++;
//            Label fromValue = new Label(1,2,fromDate);
//            sheet.addCell(fromValue);
//            Label toLabel = new Label(2,2,"To: ");
//            sheet.addCell(toLabel);
//            Label toValue = new Label(3,2,toDate);
//            sheet.addCell(toValue);
            
            for(int i = 0; i<model.getColumnCount();i++){
                  Label label = new Label(i,rowCount, model.getColumnName(i));                    
                  sheet.addCell(label);
                }
            rowCount++;
            for( int i =0; i<model.getRowCount(); i++){
                boolean isdetailed = false;
                boolean last = false;
                if((model.getValueAt(i, 0).toString().equals(" ") && !model.getValueAt(i-1, 1).toString().equals("Total"))){
                        isdetailed = true;
                    }
                if(i ==  model.getRowCount()-1){
                    last = true;
                }
                for(int j = 0; j<model.getColumnCount();j++){
                    if(model.getValueAt(i, j)!= null){
                        if(isdetailed && j > 0){
                            Label label = new Label(j-1, rowCount, model.getValueAt(i, j).toString(),tableFormat);
//                            Label label = new Label(j-1, i+5, model.getValueAt(i, j).toString());      
                            sheet.addCell(label);
                        } else if(last && j > 1){
                            Label label = new Label(j-1, rowCount, model.getValueAt(i, j).toString());      
                            sheet.addCell(label);
                        } else{
//                            sheet.mergeCells(j, i+5, j+1, i+5);
//                            Label label = new Label(j, i+5, model.getValueAt(i, j).toString()+": "+model.getValueAt(i, j+1).toString());      
                            Label label = new Label(j, rowCount, model.getValueAt(i, j).toString());
                            sheet.addCell(label);
//                            j++;
                        }
                        
                    }
                    
                    
                }
                rowCount++;
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
//            Logger.getLogger(talent_bunseki.class.getName()).log(Level.SEVERE, null, ex);
        }
            workbook.write();
            workbook.close();

        } catch (IOException ex) {
            ex.printStackTrace();
//            Logger.getLogger(talent_bunseki.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (BiffException ex){
//            ex.printStackTrace();
        }
}
 
 //DAily OTC/Daily Sales Payment/ Daily Sales Collection Report
  public static void createDailySalesWXL(String file, TableModel model, String title, String Name, String date) throws WriteException{
        try {
            WritableWorkbook workbook = Workbook.createWorkbook(new File(file));
//                      
            try{
//            WritableCellFormat textFormat = new WritableCellFormat();
            
            WritableSheet sheet = workbook.createSheet(title, 0);
              int rowCount = 0;
            sheet = setExcelHeader(sheet, rowCount);
            
            rowCount = sheet.getRows();
//            rowCount++;
//            sheet.mergeCells(0, rowCount, 1, rowCount);
//            sheet.mergeCells(0, 2, 3, 2);
             WritableCellFormat tableFormat = new WritableCellFormat();
            tableFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
             WritableCellFormat tableFormatRightALign = new WritableCellFormat();
            tableFormatRightALign.setBorder(Border.ALL, BorderLineStyle.THIN);
           tableFormatRightALign.setAlignment(Alignment.RIGHT);
           
           rowCount++;
//            sheet.mergeCells(0, 1, 1, 1);
            
//            WritableCellFormat tableFormat = new WritableCellFormat();
//            tableFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
//            Label titleLabel = new Label(0,0, title);
//            sheet.addCell(titleLabel);
            if(title.equals(" Ledger")){
                Label productLabel = new Label(0,rowCount, "Product Name:");
                sheet.addCell(productLabel);
                Label productValue = new Label(1,rowCount, Name);
                sheet.addCell(productValue);
                
            } else {
                Label productLabel = new Label(0,rowCount, "Date: "+date);
                sheet.addCell(productLabel);
//                Label productValue = new Label(1,1, date);
//                sheet.addCell(productValue);
                
            }
            rowCount+=2;
//            Label fromLabel = new Label(0,2,"From: ");
//            sheet.addCell(fromLabel);
//            Label fromValue = new Label(1,2,fromDate);
//            sheet.addCell(fromValue);
//            Label toLabel = new Label(2,2,"To: ");
//            sheet.addCell(toLabel);
//            Label toValue = new Label(3,2,toDate);
//            sheet.addCell(toValue);
//            
            for(int i = 0; i<model.getColumnCount();i++){
                  Label label = new Label(i,rowCount, model.getColumnName(i),tableFormat);                    
                  sheet.addCell(label);
                }
            rowCount++;
            for( int i =0; i<model.getRowCount(); i++){
                for(int j = 0; j<model.getColumnCount();j++){
                    Label label;
                    if( j == model.getColumnCount()-1){
                        label = new Label(j, rowCount, model.getValueAt(i, j).toString(),tableFormatRightALign);                    
                    } else {
                        label = new Label(j, rowCount, model.getValueAt(i, j).toString(),tableFormat);                    
                    }
                  sheet.addCell(label);
                }
                rowCount++;
            }
            
            sheet = setAutoFit(sheet);

        } catch (Exception ex) {
            ex.printStackTrace();
//            Logger.getLogger(talent_bunseki.class.getName()).log(Level.SEVERE, null, ex);
        }
            workbook.write();
            workbook.close();

        } catch (IOException ex) {
            ex.printStackTrace();
//            Logger.getLogger(talent_bunseki.class.getName()).log(Level.SEVERE, null, ex);
        }
}
  
  //Detailed Sales REport Supplier
  public static void createDetailedSalesXL(String file, TableModel model, String title, String Name, String fromDate, String toDate) throws WriteException{
        try {
            WritableWorkbook workbook = Workbook.createWorkbook(new File(file));
//                      
            try{
//            WritableCellFormat textFormat = new WritableCellFormat();
            
            WritableSheet sheet = workbook.createSheet(title, 0);
              int rowCount = 0;
            sheet = setExcelHeader(sheet, rowCount);
            
            rowCount = sheet.getRows();

             WritableCellFormat tableFormat = new WritableCellFormat();
            tableFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
             WritableCellFormat tableFormatRightALign = new WritableCellFormat();
            tableFormatRightALign.setBorder(Border.ALL, BorderLineStyle.THIN);
           tableFormatRightALign.setAlignment(Alignment.RIGHT);
           
           rowCount++;
            Label titleLabel = new Label(0,rowCount, title);
            sheet.addCell(titleLabel);
            
             rowCount+=2;
            Label productLabel = new Label(0,rowCount, "Client Name: "+Name);
            sheet.addCell(productLabel);
            rowCount++;
           
            Label fromLabel = new Label(0,rowCount,"Date: "+fromDate+" - "+toDate);
            sheet.addCell(fromLabel);

            rowCount+=2;
//            
            for(int i = 0; i<model.getColumnCount();i++){
                  Label label = new Label(i,rowCount, model.getColumnName(i),tableFormat);                    
                  sheet.addCell(label);
                }
            rowCount++;
            for( int i =0; i<model.getRowCount(); i++){
                for(int j = 0; j<model.getColumnCount();j++){
                    Label label;
                    if( j == model.getColumnCount()-1){
                        label = new Label(j, rowCount, model.getValueAt(i, j).toString(),tableFormatRightALign);                    
                    } else {
                        label = new Label(j, rowCount, model.getValueAt(i, j).toString(),tableFormat);                    
                    }
                  sheet.addCell(label);
                }
                rowCount++;
            }
            
            sheet = setAutoFit(sheet);

        } catch (Exception ex) {
            ex.printStackTrace();
//            Logger.getLogger(talent_bunseki.class.getName()).log(Level.SEVERE, null, ex);
        }
            workbook.write();
            workbook.close();

        } catch (IOException ex) {
            ex.printStackTrace();
//            Logger.getLogger(talent_bunseki.class.getName()).log(Level.SEVERE, null, ex);
        }
}
  
  //Detailed daily Sales Report
  public static void createDetailedDailySalesWXL(String file, TableModel model, String title, String Name, String date) throws WriteException{
        try {
            WritableWorkbook workbook = Workbook.createWorkbook(new File(file));
//                      
            try{
//            WritableCellFormat textFormat = new WritableCellFormat();
            
            WritableSheet sheet = workbook.createSheet(title, 0);
              int rowCount = 0;
            sheet = setExcelHeader(sheet, rowCount);
            
            rowCount = sheet.getRows();
//            rowCount++;
//            sheet.mergeCells(0, rowCount, 1, rowCount);
//            sheet.mergeCells(0, 2, 3, 2);
             WritableCellFormat tableFormat = new WritableCellFormat();
            tableFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
             WritableCellFormat tableFormatRightALign = new WritableCellFormat();
            tableFormatRightALign.setBorder(Border.ALL, BorderLineStyle.THIN);
           tableFormatRightALign.setAlignment(Alignment.RIGHT);
           
           rowCount++;
//            sheet.mergeCells(0, 1, 1, 1);
            
//            WritableCellFormat tableFormat = new WritableCellFormat();
//            tableFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
//            Label titleLabel = new Label(0,0, title);
//            sheet.addCell(titleLabel);
            if(title.equals(" Ledger")){
                Label productLabel = new Label(0,rowCount, "Product Name:");
                sheet.addCell(productLabel);
                Label productValue = new Label(1,rowCount, Name);
                sheet.addCell(productValue);
                
            } else {
                Label productLabel = new Label(0,rowCount, "Date: "+date);
                sheet.addCell(productLabel);
//                Label productValue = new Label(1,1, date);
//                sheet.addCell(productValue);
                
            }
            rowCount+=2;
//            Label fromLabel = new Label(0,2,"From: ");
//            sheet.addCell(fromLabel);
//            Label fromValue = new Label(1,2,fromDate);
//            sheet.addCell(fromValue);
//            Label toLabel = new Label(2,2,"To: ");
//            sheet.addCell(toLabel);
//            Label toValue = new Label(3,2,toDate);
//            sheet.addCell(toValue);
//            
            for(int i = 0; i<model.getColumnCount();i++){
                  Label label = new Label(i,rowCount, model.getColumnName(i),tableFormat);                    
                  sheet.addCell(label);
                }
            rowCount++;
            for( int i =0; i<model.getRowCount(); i++){
                for(int j = 0; j<model.getColumnCount();j++){
                    Label label;
//                    if( j == model.getColumnCount()-1){
//                        label = new Label(j, rowCount, model.getValueAt(i, j).toString(),tableFormatRightALign);                    
//                    } else {
                        label = new Label(j, rowCount, model.getValueAt(i, j).toString(),tableFormat);                    
//                    }
                  sheet.addCell(label);
                }
                rowCount++;
            }
            
            sheet = setAutoFit(sheet);

        } catch (Exception ex) {
            ex.printStackTrace();
//            Logger.getLogger(talent_bunseki.class.getName()).log(Level.SEVERE, null, ex);
        }
            workbook.write();
            workbook.close();

        } catch (IOException ex) {
            ex.printStackTrace();
//            Logger.getLogger(talent_bunseki.class.getName()).log(Level.SEVERE, null, ex);
        }
}
 
 
 private static void createExcelSheet(TableModel mod, String title, WritableWorkbook workbook) throws WriteException{
        try {
            WritableSheet sheet = workbook.createSheet(title, 0);
            for(int i = 0; i<mod.getColumnCount();i++){
                  Label label = new Label(i,0, mod.getColumnName(i));                    
                  sheet.addCell(label);
                }
            for( int i =0; i<mod.getRowCount(); i++){
                for(int j = 0; j<mod.getColumnCount();j++){
                  Label label = new Label(j, i+1, mod.getValueAt(i, j).toString());                    
                  sheet.addCell(label);
                }
            }
//            Label label = new Label(0, 0, "Employee No.");
//            Label label1 = new Label(1, 0, "Name");
//            sheet.addCell(label);
//            sheet.addCell(label1);
//            WritableCellFormat tf = new WritableCellFormat();
//            tf.setAlignment(jxl.format.Alignment.RIGHT);
//            int col = 2;
//            for (int z = 0; z < day.size(); z++) {
//                Label label2 = new Label(col + z, 0, day.get(z).toString());
//                sheet.addCell(label2);
//            }
//            int rowcnt = 0;
//            int t = 0;
//            for (int x = 0; x < val.size(); x++) {
//                t = x %6 ;
//                if (x %6 == 0) {
//                    rowcnt++;
//                }
//                if(t==1){
//                    Label num = new Label(t, rowcnt, val.get(x).toString());
//                    sheet.addCell(num);
//                }else{
//                    Label num = new Label(t, rowcnt, val.get(x).toString(),tf);
//                    sheet.addCell(num);
//                }
//                
//            }

//            JFreeChart chart = geninGraph(xLabel, type);
////            BufferedImage image = chart.createBufferedImage((currEmployee.size()*117), 500);
////            BufferedImage image = chart.createBufferedImage(700, 500);
//            int width = image.getWidth();
//            int height = image.getHeight();
//            Double w = width + 0.0;
//            Double h = height + 0.0;
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            ImageIO.write(image, "PNG", baos);
//            WritableImage img = new WritableImage(0,currEmployee.size()+1, 15, (currEmployee.size()*10), baos.toByteArray());
//            sheet.addImage(img);
        } catch (Exception ex) {
            ex.printStackTrace();
//            Logger.getLogger(talent_bunseki.class.getName()).log(Level.SEVERE, null, ex);
        }
}

 
 //Transfer Report
 public static void createTransferWXL(String file, TableModel model, String title, String fromDate, String toDate) throws WriteException{
        try {
            WritableWorkbook workbook = Workbook.createWorkbook(new File(file));
//             String curdir = System.getProperty("user.dir");
//                            Workbook workbook = Workbook.getWorkbook(new File(curdir+"\\src\\NCS\\Analysis\\Pslip.xls"));
//            Workbook template = Workbook.getWorkbook(new File(curdir+"\\ledgerFormatDate.xls"));
//            WritableWorkbook workbook = Workbook.createWorkbook(new File(file), template);
            
//            createExcelSheet(model, title, workbook);
//            for(int i = 0; i<4; i++){
//                switch(i){
//
//                    
//                    case 1 : createinWSheet(workbook,  "Absences Per Week Analysis", inabsentWVal, inabsentWD, "Absences Per Week", 1);
//                           break;
//                    case 2 : createinWSheet(workbook,  "Late Per Week Analysis", inlateWVal, inlateWD, "Late Per Week", 2);
//                            break;
//                    case 3 : createinWSheet(workbook,  "Penalties Per Week Analysis", inpenalWVal, inpenalWD, "Penalties Per Week", 3);
//                            break;
//                    default : 
//                            createinWSheet(workbook,  "Attendance Per Week Analysis", inattendWVal, inattendWD, "Attendance Per Week", 0);
//                           break;
//                }
//            }
            
            try{
                
//            WritableCellFormat textFormat = new WritableCellFormat();
//            textFormat.setWrap(true);
            
            
            
//            WritableCellFormat tableFormat = new WritableCellFormat();
//            tableFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
//            textFormat.setWrap(true);
//            boolean isdetailed = false;
            WritableSheet sheet = workbook.createSheet(title, 0);
            
                  int rowCount = 0;
            sheet = setExcelHeader(sheet, rowCount);
            
            rowCount = sheet.getRows();
//            rowCount++;
//            sheet.mergeCells(0, rowCount, 1, rowCount);
//            sheet.mergeCells(0, 2, 3, 2);
             WritableCellFormat tableFormat = new WritableCellFormat();
            tableFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
             WritableCellFormat tableFormatRightALign = new WritableCellFormat();
            tableFormatRightALign.setBorder(Border.ALL, BorderLineStyle.THIN);
           tableFormatRightALign.setAlignment(Alignment.RIGHT);
//            sheet.mergeCells(0, 1, 1, 1);
//            sheet.mergeCells(0, 2, 1, 2);
//            sheet.mergeCells(2 , 2 , 3 , 2);
//            sheet.mergeCells(0 , 2 , 3 , 2);
//            WritableSheet sheet = (WritableSheet) workbook.getSheet(0);
//            sheet.setName(title);
            
//            WritableCell mergedText = (WritableCell) sheet.getCell(0, 2);
            
//            WritableCell mergedDate = (WritableCell) sheet.getCell(0, 3);
            
//            WritableCellFormat mergedFormat = new WritableCellFormat(mergedText.getCellFormat());
//            WritableCellFormat mergedDateFormat = new WritableCellFormat(mergedDate.getCellFormat());
            
            WritableCellFormat textFormat = new WritableCellFormat();
            textFormat.setWrap(true);
            
            
            
//            WritableCellFormat tableFormat = new WritableCellFormat();
//            tableFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
//            textFormat.setWrap(true);
            
            rowCount++;
            Label titleLabel = new Label(0,rowCount, title);
            sheet.addCell(titleLabel);
            rowCount++;
//            if(title.equals("Item Ledger")){
//                Label productLabel = new Label(0,1, "Product Name:");
//                sheet.addCell(productLabel);
//                Label productValue = new Label(1,1, Name);
//                sheet.addCell(productValue);
//            } else {
//                Label productLabel = new Label(0,1, "Client Name: "+Name);
//                sheet.addCell(productLabel);
////                Label productValue = new Label(1,1, Name);
////                sheet.addCell(productValue);
//            }
            Label fromLabel = new Label(0,rowCount,"Date: "+fromDate+" - "+toDate);
            sheet.addCell(fromLabel);
            rowCount+=2;
//            Label fromValue = new Label(1,2,fromDate);
//            sheet.addCell(fromValue);
//            Label toLabel = new Label(2,2,"To: ");
//            sheet.addCell(toLabel);
//            Label toValue = new Label(3,2,toDate);
//            sheet.addCell(toValue);
            
//            for(int i = 0; i<model.getColumnCount();i++){
//                  Label label = new Label(i,4, model.getColumnName(i));                    
//                  sheet.addCell(label);
//                }
            for( int i =0; i<model.getRowCount(); i++){
                boolean isdetailed = false;
                boolean last = false;
                
                if(i+1 != model.getRowCount() && (model.getValueAt(i, 0).toString().equals(" ") && !model.getValueAt(i+1, 0).toString().equals("Transfer #"))){
                        isdetailed = true;
                    }
                for(int j = 0; j<model.getColumnCount();j++){
                    if(model.getValueAt(i, j)!= null){
                        if(isdetailed && j > 0){
                            Label label = new Label(j-1, rowCount, model.getValueAt(i, j).toString(),tableFormat);
//                            Label label = new Label(j-1, i+5, model.getValueAt(i, j).toString());      
                            sheet.addCell(label);
                        } else{
//                            sheet.mergeCells(j, i+4, j+1, i+4);
//                            Label label = new Label(j, i+5, model.getValueAt(i, 0).toString()+": "+model.getValueAt(i, 1).toString());      
                            Label label = new Label(j, rowCount, model.getValueAt(i, j).toString());
                            sheet.addCell(label);
//                            j++;
                        }
                        
                    }
                    
                    
                }
                rowCount++;
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
//            Logger.getLogger(talent_bunseki.class.getName()).log(Level.SEVERE, null, ex);
        }
            workbook.write();
            workbook.close();

        } catch (IOException ex) {
            ex.printStackTrace();
//            Logger.getLogger(talent_bunseki.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (BiffException ex){
//            ex.printStackTrace();
        }
}
 
 private static WritableSheet setAutoFit(WritableSheet sheet){
  WritableSheet sh = sheet;
    for(int i = 0; i<sh.getColumns();i++){
           CellView  cell =sheet.getColumnView(i);
            cell.setAutosize(true);
            sheet.setColumnView(i, cell);
   }
  return sh;
 }
 
 private static WritableSheet setExcelHeader(WritableSheet sheet, int rowCount)throws Exception{
            WritableSheet sh = sheet;
                
                WritableFont f = new WritableFont(WritableFont.ARIAL, WritableFont.DEFAULT_POINT_SIZE,WritableFont.BOLD );
//                f.setBoldStyle();
                WritableCellFormat textFormatBold = new WritableCellFormat(f);
                
                WritableCellFormat textFormat = new WritableCellFormat();
                WritableFont f2 = new WritableFont(WritableFont.ARIAL);
                textFormat.setFont(f2);
                
                Properties prop = new Properties();
                prop.load(new FileInputStream("pos_config.properties"));
                String header = prop.getProperty("excelHeader");
                String address = prop.getProperty("excelAddress");
                String phone = prop.getProperty("excelTelNo");
                Label headerLabel = new Label(0,rowCount, header,textFormatBold);
                sh.addCell(headerLabel);
                rowCount++;
                Label addressLabel = new Label(0,rowCount, address,textFormat);
                sh.addCell(addressLabel);
                rowCount++;
                Label phoneLabel = new Label(0,rowCount, phone,textFormat);
                sh.addCell(phoneLabel);
                rowCount++;
                
                return sh;
}
 
 
 public static void createCheckVoucherWXL(String file, TableModel model, String title, String name) throws WriteException{
        try {
//             WritableWorkbook workbook = Workbook.createWorkbook(new File(file));
            String curdir = System.getProperty("user.dir");
                            Workbook workbook = Workbook.getWorkbook(new File(curdir+"\\src\\pos_project\\Excel\\VOUCHER.xls"));
                            WritableWorkbook copy = Workbook.createWorkbook(new File(file), workbook);

             try {
                 WritableSheet sheet = (WritableSheet) copy.getSheet(0);
//            WritableSheet sheet = workbook.createSheet(title, 0);
             int rowCount = 0;
            sheet = setExcelHeader(sheet, rowCount);
            
            rowCount = 3;
            WritableCellFormat dateFormat = new WritableCellFormat(sheet.getCell(5, rowCount).getCellFormat());
            
            Label dateLabel = new Label(5,rowCount, Formats.dateFormatDays2.format(new GregorianCalendar().getTime()), dateFormat);
            sheet.addCell(dateLabel);
            rowCount+=2;
//            sheet.mergeCells(0, rowCount, 1, rowCount);
//            sheet.mergeCells(0, 2, 3, 2);
          
            
            
//             WritableCellFormat tableFormat = new WritableCellFormat();
//            tableFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
//            int rowCount =0;
            
            
//            sheet.mergeCells(0, rowCount, 1, rowCount);
            WritableCellFormat supplierFormat = new WritableCellFormat(sheet.getCell(2, rowCount).getCellFormat());
                Label supplierLabel = new Label(2,rowCount, name, supplierFormat);
                sheet.addCell(supplierLabel);
            
            rowCount += 2;
//            for(int i = 0; i<model.getColumnCount();i++){
//                  Label label = new Label(i,rowCount, model.getColumnName(i),tableFormat);                    
//                  sheet.addCell(label);
//                }
           rowCount++;
           WritableCellFormat boldFormat = new WritableCellFormat(sheet.getCell(1, 23).getCellFormat());
           boldFormat.setAlignment(Alignment.RIGHT);
           WritableCellFormat tableFormat = new WritableCellFormat(sheet.getCell(2, 23).getCellFormat());
           WritableCellFormat lastLineFormat = new WritableCellFormat(sheet.getCell(2, 17).getCellFormat());
//            tableFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
           WritableCellFormat tableFormatRightALign = new WritableCellFormat(sheet.getCell(2, 23).getCellFormat());
//            tableFormatRightALign.setBorder(Border.LEFT, BorderLineStyle.THIN);
//            tableFormatRightALign.setBorder(Border.RIGHT, BorderLineStyle.THIN);
           tableFormatRightALign.setAlignment(Alignment.RIGHT);
           
           
            for( int i =0; i<model.getRowCount(); i++){
                for(int j = 1; j<model.getColumnCount();j++){
                  Label label;  
                  if(i == 9){
                      label = new Label(j, rowCount, model.getValueAt(i, j).toString(),lastLineFormat);
                  }else if(j == 2 || j == 5){
                      label = new Label(j, rowCount, model.getValueAt(i, j).toString(),tableFormatRightALign);                    
                  }else if( model.getValueAt(i, j).equals("TOTAL:")){
                      
                      label = new Label(j, rowCount, model.getValueAt(i, j).toString(),boldFormat);
                  }else{
                      label = new Label(j, rowCount, model.getValueAt(i, j).toString(),tableFormat);                    
                  }
                   
                  sheet.addCell(label);
                }
                rowCount++;
            }
            Label clearBoldLabel = new Label (1,23," ");
            sheet.addCell(clearBoldLabel);
            Label clearRightLabel = new Label (2,23," ");
            sheet.addCell(clearRightLabel);
            sheet = setAutoFit(sheet);

        } catch (Exception ex) {
            ex.printStackTrace();
//            Logger.getLogger(talent_bunseki.class.getName()).log(Level.SEVERE, null, ex);
        }
            copy.write();
            copy.close();
            workbook.close();

        } catch (Exception ex) {
            ex.printStackTrace();
//            Logger.getLogger(talent_bunseki.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
