package org.action;

import java.io.FileOutputStream;
import java.lang.reflect.Type;
import java.util.Iterator; 
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import com.google.gson.Gson;    
import com.google.gson.reflect.TypeToken; 

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.easybooks.test.model.vo.Book;

public class exportDatasAction {
//	private List<Book> rows;
//	private int total;
//	private String test;
//	public void setRows(List<Book> rows) {
//		this.rows = rows;
//	}
//	public void setTotal(int total) {
//		this.total = total;
//	}
//	public void setTest(String test) {
//		this.test = test;
//	}
//	public String exportDatas() {
//		// 第一步，创建一个webbook，对应一个Excel文件
//		System.out.println("导出");
//		System.out.println(test);
////		test.replace();
//		String t = test.replaceAll("\"", "\\\\\"");
//		System.out.println(t);
//		String tt = "[{\"author\":\"lq\",\"bc\":10,\"bn\":\"tp313\",\"price\":3,\"roomNo\":\"201\",\"state\":\"已借\",\"title\":\"周日\",\"wst\":\"2017-06-23T08:42:36\"},{\"author\":\"cc\",\"bc\":11,\"bn\":\"tp315\",\"price\":16.4,\"roomNo\":\"301\",\"state\":\"已借\",\"title\":\"js\",\"wst\":\"2017-06-23T08:42:36\"},{\"author\":\"dd\",\"bc\":12,\"bn\":\"tp314\",\"price\":56,\"roomNo\":\"401\",\"state\":\"未借\",\"title\":\"css\",\"wst\":\"2017-06-23T08:42:36\"},{\"author\":\"lq\",\"bc\":13,\"bn\":\"tp313\",\"price\":78,\"roomNo\":\"501\",\"state\":\"已借\",\"title\":\"java程序\",\"wst\":\"2017-06-23T08:42:36\"},{\"author\":\"tt\",\"bc\":14,\"bn\":\"tp256\",\"price\":45.8,\"roomNo\":\"301\",\"state\":\"未借\",\"title\":\"c\",\"wst\":\"2017-06-23T14:51:59\"},{\"author\":\"cc\",\"bc\":16,\"bn\":\"tp222\",\"price\":22,\"roomNo\":\"301\",\"state\":\"未借\",\"title\":\"高数\",\"wst\":\"2017-12-09T14:38:45\"},{\"author\":\"11\",\"bc\":20,\"bn\":\"tp333\",\"price\":22,\"roomNo\":\"201\",\"state\":\"未借\",\"title\":\"1234\",\"wst\":\"2017-12-10T17:26:14\"},{\"author\":\"123\",\"bc\":21,\"bn\":\"tp222\",\"price\":22,\"roomNo\":\"301\",\"state\":\"未借\",\"title\":\"高数\",\"wst\":\"2017-12-10T17:29:00\"},{\"author\":\"cc\",\"bc\":22,\"bn\":\"tp313\",\"price\":12,\"roomNo\":\"201\",\"state\":\"未借\",\"title\":\"cc\",\"wst\":\"2017-12-18T11:28:02\"},{\"author\":\"1\",\"bc\":23,\"bn\":\"tp314\",\"price\":12,\"roomNo\":\"201\",\"state\":\"未借\",\"title\":\"cc\",\"wst\":\"2017-12-18T11:28:50\"}]";
//		Gson gson = new Gson(); 
//		 List<Book> retList = gson.fromJson(tt, new TypeToken<List<Book>>() {}.getType());  
//	        for (Book book : retList) {  
//	        	System.out.println("book");
//	            System.out.println(book);  
//	        } 
//		
////		Type listType = new TypeToken<LinkedList<Book>>(){}.getType();    
////		LinkedList<Book> books = gson.fromJson(test, listType);    
////		System.out.println(books.size());
////		for (Iterator iterator = books.iterator(); iterator.hasNext();) {    
////		    Book book = (Book) iterator.next();    
////		    System.out.println(book.getBn());    
////		} 
//        HSSFWorkbook wb = new HSSFWorkbook();  
//        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
//        HSSFSheet sheet = wb.createSheet("图书表一");  
//        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
//        HSSFRow row = sheet.createRow((int) 0);  
//        // 第四步，创建单元格，并设置值表头 设置表头居中  
//        HSSFCellStyle style = wb.createCellStyle();  
//        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
//  
//
//        HSSFCell cell = row.createCell((short) 0);  
//        cell.setCellValue("条形码");  
//        cell.setCellStyle(style);  
//        cell = row.createCell((short) 1);  
//        cell.setCellValue("书号");  
//        cell.setCellStyle(style);  
//        cell = row.createCell((short) 2);  
//        cell.setCellValue("书名");  
//        cell.setCellStyle(style);  
//        cell = row.createCell((short) 3);  
//        cell.setCellValue("作者");  
//        cell.setCellStyle(style);  
//        cell = row.createCell((short) 4);  
//        cell.setCellValue("价格");  
//        cell.setCellStyle(style);  
//        cell = row.createCell((short) 5);  
//        cell.setCellValue("入库时间");  
//        cell.setCellStyle(style);  
//        cell = row.createCell((short) 6);  
//        cell.setCellValue("房号");  
//        cell.setCellStyle(style);  
//        cell = row.createCell((short) 7);  
//        cell.setCellValue("借阅状态");  
//        cell.setCellStyle(style);  
//        int i=0;
//        for (Book book : rows) {
//        	  row = sheet.createRow((int) i + 1);  
//	            i++;
//	        //    row.createCell((short) 0).setCellValue();  
//	            row.createCell((short) 1).setCellValue(book.getBc());  
//	            row.createCell((short) 2).setCellValue(book.getBn()); 
//	            row.createCell((short) 3).setCellValue(book.getTitle());  
//	            row.createCell((short) 4).setCellValue(book.getAuthor());  
//	            row.createCell((short) 5).setCellValue(book.getPrice());  
//	            row.createCell((short) 6).setCellValue(book.getWst());  
//	            row.createCell((short) 7).setCellValue(book.getRoomNo());
//	            row.createCell((short) 8).setCellValue(book.getState());
//			}
//
//        row = sheet.createRow((int) i+1);  
//        row.createCell((short) 0).setCellValue("总计");  
//        row.createCell((short) 1).setCellValue(total);  
//        
//        
//              // 第六步，将文件存到指定位置  
//        try  
//        {  	                	
//        	SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");//设置日期格式
//        	
//            FileOutputStream fout = new FileOutputStream("D:\\导出excel表格\\"+df.format(new Date())+".xls");
//            wb.write(fout);  
//            fout.close();   	
//        	
//           
//          
//            
//        }  
//        catch (Exception e)  
//        {  
//            e.printStackTrace();  
//        }  
//		return "success";
//	}
//	public String trim(String source, String leftTrim, String rightTrim) {
//        if(source==null){
//            return "";
//        }
//        source = source.trim(); // 循环去掉字符串首的beTrim字符
//        if(source.isEmpty()){
//            return "";
//        }
//        String beginChar = source.substring(0, 1);
//        if (beginChar.equalsIgnoreCase(leftTrim)) {
//            source = source.substring(1, source.length());
//            beginChar = source.substring(0, 1);
//        }
//        // 循环去掉字符串尾的beTrim字符
//        String endChar = source.substring(source.length() - 1, source.length());
//        if (endChar.equalsIgnoreCase(rightTrim)) {
//            source = source.substring(0, source.length() - 1);
//            endChar = source.substring(source.length() - 1, source.length());
//        }
//        System.out.println(source);
//        return source;
//    }
	public String exportData(List<Book> allBooks) {
//		System.out.println("导出");
		HSSFWorkbook wb = new HSSFWorkbook();  
		
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
        HSSFSheet sheet = wb.createSheet("图书表一");  
        //设置单元格宽度
        sheet.setColumnWidth(6, 20 * 256);
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
        HSSFRow row = sheet.createRow((int) 0);  
        // 第四步，创建单元格，并设置值表头 设置表头居中  
        HSSFCellStyle style = wb.createCellStyle();  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
  

        HSSFCell cell = row.createCell((short) 1);  
        cell.setCellValue("条形码");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 2);  
        cell.setCellValue("书号");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 3);  
        cell.setCellValue("书名");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 4);  
        cell.setCellValue("作者");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 5);  
        cell.setCellValue("价格");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 6);  
        cell.setCellValue("入库时间");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 7);  
        cell.setCellValue("房号");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 8);  
        cell.setCellValue("借阅状态");  
        cell.setCellStyle(style);  
        int i=0;
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss");//设置日期格式
        for (Book book : allBooks) {
        	  row = sheet.createRow((int) i + 1);  
	            i++;
	        //    row.createCell((short) 0).setCellValue();  
	            row.createCell((short) 1).setCellValue(book.getBc());  
	            
	            row.createCell((short) 2).setCellValue(book.getBn()); 
	            row.createCell((short) 3).setCellValue(book.getTitle());  
	            row.createCell((short) 4).setCellValue(book.getAuthor());  
	            row.createCell((short) 5).setCellValue(book.getPrice());  
	            row.createCell((short) 6).setCellValue(sd.format(book.getWst()));  
	            row.createCell((short) 7).setCellValue(book.getRoomNo());
	            row.createCell((short) 8).setCellValue(book.getState());
			}
        row = sheet.createRow((int) i+1);  
        row.createCell((short) 0).setCellValue("总计");  
        row.createCell((short) 1).setCellValue(allBooks.size());  
        
        
              // 第六步，将文件存到指定位置  
        try  
        {  	                	
        	SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");//设置日期格式
        	
            FileOutputStream fout = new FileOutputStream("D:\\导出excel表格\\"+df.format(new Date())+".xls");
            wb.write(fout);  
            fout.close();   	        
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
        }  
		return "success";
	}
}
