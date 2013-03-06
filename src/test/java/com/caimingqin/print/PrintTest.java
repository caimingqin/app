package com.caimingqin.print;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class PrintTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		ComThread.InitSTA();
		ActiveXComponent xl = new ActiveXComponent("Excel.Application");
		Dispatch.put(xl, "Visible", new Variant(true));
		Dispatch workbooks = xl.getProperty("Workbooks").toDispatch();
		// ´ò¿ªÎÄµµ
		Dispatch excel = Dispatch.call(workbooks, "Open", "D:/goal.xls")
				.toDispatch();

		Dispatch.get(excel, "PrintOut");

		ComThread.Release();

	}

}
