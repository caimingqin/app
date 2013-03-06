package com.caimingqin.app.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.caimingqin.app.interfaces.Command;
import com.caimingqin.app.listener.CommandContainer;

public class DefaultHandlerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String commandName = req.getParameter("commandName");
			System.out.println("commandName======>" + commandName);
			CommandContainer singleInstance = CommandContainer.getSingleInstance();
			Map<String, Class<? extends Command>> containerMap = singleInstance.getContainerMap();
			Class<? extends Command> class1 = containerMap.get(commandName);
			if (class1 != null) {
				Command newInstance = class1.newInstance();
				Object object = newInstance.excute();
				ObjectMapper objectMapper = new ObjectMapper();
				String str = objectMapper.writeValueAsString(object);
				System.out.println("===================>>" + str);
				resp.getWriter().print(str);
			}
		} catch (Exception e) {
			System.out.println("e.getMessage()=====================>" + e.getMessage());
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
