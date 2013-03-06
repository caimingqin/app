package com.caimingqin.app.web;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("file")
public class DownloadController {

	@RequestMapping("download")
	public void downloadFile(HttpServletResponse response) {
		try {
			System.out.println("download======================>start");
			response.reset();
			response.setCharacterEncoding("utf-8");
//			response.setContentType("application/vnd.ms-excel; charset=UTF-8");
			 response.setContentType("multipart/form-data");  
			String fileName = URLEncoder.encode("Excel�ļ�����", "utf-8");
			response.setHeader("Content-Disposition", "attachment;fileName="
					+ fileName+".xls");
			OutputStream out = null;
			out = response.getOutputStream();
			Workbook wb = new HSSFWorkbook();
			Sheet sheet = wb.createSheet("��Ʒ���䵼��");
			// �� �� ���� �����̱�� ������ ��Ʒ��� ��Ʒ ��������
			String[] titles = { "��", "����", "�����̱��", "������", " ��Ʒ��� ", "��������" };
			Row row0 = sheet.createRow(0);
			for (int i = 0; i < titles.length; i++) {
				row0.createCell(i).setCellValue(titles[i]);
			}
			wb.write(out);
			out.close();
			System.out.println("out.close()======================>end");
		} catch (IOException e) {
			System.out.println("IOException======>" + e.getMessage());
		}

	}
	
	@ResponseBody
	@RequestMapping("/map")
	public Map<String, List<String>> getMap() {
		Map<String, List<String>> map =new HashMap<String, List<String>>();
		List<String> all=new ArrayList<String>();
		all.add("a");
		all.add("b");
		all.add("c");
		all.add("d");
		map.put("1", all);
		map.put("2", all);
		map.put("3", all);
		map.put("4", all);
		
		return map;
	}
}
