package com.caimingqin.app.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

public class ExportExcelUtil {
	private static Log logger = LogFactory.getLog(ExportExcelUtil.class
			.getName());

	@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
	public static <T> void exportExcel(String[] headers, List<T> objects,
			String fileName, Class clazz, HttpServletResponse response) {
		response.setContentType("application/vnd.ms-excel");
		String codedFileName = null;
		OutputStream os = null;
		try {
			// 进行转码，使其支持中文文件名
			SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddHHmmss");
			String time = ft.format(new Date());
			codedFileName = java.net.URLEncoder
					.encode(fileName + time, "UTF-8");
			response.setHeader("content-disposition", "attachment;filename="
					+ codedFileName + ".xls");
			// 产生工作簿对象
			HSSFWorkbook workbook = new HSSFWorkbook();
			// 产生工作表对象
			HSSFSheet sheet = workbook.createSheet();
			// 设置表格默认列宽度为15个字节
			sheet.setDefaultColumnWidth((short) 15);
			// 生成一个样式
			HSSFCellStyle style = workbook.createCellStyle();
			// 设置这些样式
			style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style.setBorderTop(HSSFCellStyle.BORDER_THIN);
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			// 生成一个字体
			HSSFFont font = workbook.createFont();
			font.setColor(HSSFColor.VIOLET.index);
			font.setFontHeightInPoints((short) 12);
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			// 把字体应用到当前的样式
			style.setFont(font);
			HSSFCellStyle style2 = workbook.createCellStyle();
			style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
			style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
			style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			// 生成另一个字体
			HSSFFont font2 = workbook.createFont();
			font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
			// 把字体应用到当前的样式
			style2.setFont(font2);
			// 产生表格标题行
			HSSFRow row = sheet.createRow(0);
			for (short i = 0; i < headers.length; i++) {
				HSSFCell cell = row.createCell(i);
				cell.setCellStyle(style);
				HSSFRichTextString text = new HSSFRichTextString(headers[i]);
				cell.setCellValue(text);
			}
			Field[] fields = clazz.getDeclaredFields();
			logger.info("List<T>:[" + objects.size() + "]" + "fields.length:["
					+ fields.length + "]");
			for (int i = 0; i < objects.size(); i++) {
				row = sheet.createRow(i + 1);
				for (int j = 0; j < fields.length; j++) {
					HSSFCell c = row.createCell(j);
					Method me = clazz.getDeclaredMethod("get"
							+ fields[j].getName().substring(0, 1).toUpperCase()
							+ fields[j].getName().substring(1));
					c.setCellValue(me.invoke(objects.get(i)).toString());
					c.setCellStyle(style2);
				}
			}
			os = response.getOutputStream();
			workbook.write(os);
		} catch (UnsupportedEncodingException e1) {
		} catch (Exception e) {
		} finally {
			try {
				if (os != null) {
					os.flush();
					os.close();
				}
			} catch (IOException e) {
			}
		}

	}

	public static void writeWorkbookToResponse(String fileName, Workbook wb,
			HttpServletResponse response) {
		response.setContentType("application/vnd.ms-excel");
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		String time = ft.format(new Date());
		OutputStream os = null;
		try {
			fileName = java.net.URLEncoder.encode(fileName + time, "UTF-8");
			response.setHeader("content-disposition", "attachment;filename="
					+ fileName + ".xls");
			os = response.getOutputStream();
			wb.write(os);
		} catch (Exception e) {

		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {

				}
			}
		}
	}

	public static Workbook createWorkbook(String sheetName, Object[] headers,
			List<Object[]> rowContents) {
		Workbook wb = new HSSFWorkbook();
		CellStyle headerStyle = wb.createCellStyle();
		Font font = wb.createFont();
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		headerStyle.setFont(font);
		headerStyle.setAlignment(CellStyle.ALIGN_LEFT);
		headerStyle.setVerticalAlignment(CellStyle.ALIGN_LEFT);
		CellStyle coulunmsStyle = wb.createCellStyle();
		coulunmsStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		coulunmsStyle.setVerticalAlignment(HSSFCellStyle.ALIGN_LEFT);
		Sheet sheet = wb.createSheet(sheetName);
		Row row0 = sheet.createRow(0);
		Map<Integer, Integer> lengthMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < headers.length; i++) {// 生成头
			Cell cell = row0.createCell(i);
			cell.setCellStyle(headerStyle);
			String cellValue = headers[i].toString();
			cell.setCellValue(cellValue);
			int length = cellValue.getBytes().length;
			int defaultLength = createLength(length);
			sheet.setColumnWidth(i, defaultLength);// 设置列宽
			lengthMap.put(i, defaultLength);
		}
		for (int i = 0; i < rowContents.size(); i++) {
			Object[] objects = rowContents.get(i);
			Row row = sheet.createRow(i + 1);
			for (int col = 0; col < objects.length; col++) {
				Cell cell = row.createCell(col);
				String cellValue = objects[col].toString();
				int length = cellValue.getBytes().length;
				length = createLength(length);
				if (lengthMap.get(col) < length) {
					sheet.setColumnWidth(col, length);// 设置列宽
				}
				if (isNumber(cellValue)) {
					cell.setCellValue(Double.parseDouble(cellValue));
				} else {
					cell.setCellValue(cellValue);
				}
				cell.setCellStyle(coulunmsStyle);
			}
		}
		return wb;
	}
	
	
	public static Workbook createWorkbook(String sheetName,List<Header> headers,List<Object[]> rowContents){
		Workbook wb=new HSSFWorkbook();
		CellStyle headerStyle = wb.createCellStyle();
		Font font = wb.createFont();
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		headerStyle.setFont(font);
		headerStyle.setAlignment(CellStyle.ALIGN_LEFT);
		headerStyle.setVerticalAlignment(CellStyle.ALIGN_LEFT);
		
		CellStyle colspaStyle = wb.createCellStyle();
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		colspaStyle.setFont(font);
		colspaStyle.setAlignment(CellStyle.ALIGN_CENTER);
		colspaStyle.setVerticalAlignment(CellStyle.ALIGN_CENTER);
		
		colspaStyle.setFillForegroundColor(IndexedColors.RED.getIndex());//设置单元格背景色
		colspaStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);//设置单元格背景色

		CellStyle coulunmsStyle = wb.createCellStyle();
		coulunmsStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		coulunmsStyle.setVerticalAlignment(HSSFCellStyle.ALIGN_LEFT);
		//===================================================================================================//
		Sheet sheet=wb.createSheet(sheetName);
		Map<Integer, Row> map=new HashMap<Integer, Row>();
		Map<Integer, Integer> lengthMap=new HashMap<Integer, Integer>();
		int initRow=0;
		for(Header d:headers){//生成头
			sheet.addMergedRegion(new CellRangeAddress(d.getFirstRow(),d.getLastRow(),d.getFirstCol(),d.getLastCol()));   
			int rowNum = d.getRowNum();
			int columnNum = d.getColumnNum();
			String value = d.getValue();
			int firstCol = d.getFirstCol();
			int lastCol = d.getLastCol();
			Row row = map.get(rowNum);
			if((rowNum+1)>initRow){
				initRow=rowNum+1;
			}
			if(row==null){
			  row = sheet.createRow(rowNum);
			  map.put(d.getRowNum(), row);
			}
			Cell cell = row.createCell(columnNum);
			cell.setCellValue(value);
			if(firstCol-lastCol!=0){
				cell.setCellStyle(colspaStyle);
			}else{
				cell.setCellStyle(headerStyle);
				int length = value.toString().getBytes().length;
				int defaultLength = createLength(length);
				sheet.setColumnWidth(columnNum, defaultLength);// 设置列宽
				lengthMap.put(columnNum, defaultLength);
			}
		}
		
		for (int rowNum=0 ;rowNum<rowContents.size() ;rowNum++) { //生成body
			Object[] value = rowContents.get(rowNum);
			int colunmLength = value.length;
			Row row = sheet.createRow(rowNum+initRow);//
			for (int j = 0; j < colunmLength; j++) {
				Cell cell = row.createCell(j);
				String string = value[j].toString();
				int defaultColumnWidth = lengthMap.get(j);
				int length = string.getBytes().length;
				length = createLength(length);
				if (defaultColumnWidth < length) {
					sheet.setColumnWidth(j, length);// 2 3 4 设置列宽
				}
				if (isNumber(string)) {
					cell.setCellValue(Integer.parseInt(string));
				} else {
					cell.setCellValue(string);
				}
				cell.setCellStyle(coulunmsStyle);
			}
		}
		return wb;
	}
	

	private static int createLength(int length) {
		return length * 256 + 500;

	}

	private static boolean isNumber(String str) {
		if (str == null || "".equals(str)) {
			return false;
		}
		return str.matches("[\\d]+") || str.matches("[\\d]+[.]{1}[\\d]+");
	}

	public static class Header {
		private String value;
		private int firstRow, lastRow, firstCol, lastCol, rowNum, columnNum;

		public Header(int rowNum, int columnNum, String value, int firstRow, int lastRow, int firstCol, int lastCol) {
			this.value = value;
			this.rowNum = rowNum;
			this.columnNum = columnNum;
			this.firstRow = firstRow;
			this.lastRow = lastRow;
			this.firstCol = firstCol;
			this.lastCol = lastCol;
		}

		public String getValue() {
			return value;
		}

		public int getFirstRow() {
			return firstRow;
		}

		public int getLastRow() {
			return lastRow;
		}

		public int getFirstCol() {
			return firstCol;
		}

		public int getLastCol() {
			return lastCol;
		}

		public int getRowNum() {
			return rowNum;
		}

		public int getColumnNum() {
			return columnNum;
		}

	}

}
