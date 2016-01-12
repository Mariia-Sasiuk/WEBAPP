package java_.lab3.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Main extends HttpServlet {
    private Map<String,Actions> actionMap = new HashMap<String,Actions>();

    private void initActionMap(){
        actionMap.put("edit", new navigateEdit());
        actionMap.put("navigation", new navigateMain());
        actionMap.put("help", new navigateHelp() );
        actionMap.put("insDept", new newDepartment() );
        actionMap.put("insEmp", new newEmployee());
        actionMap.put("empView", new ViewEmployees());
        actionMap.put("deptView", new ViewDepartments());
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        initActionMap();

        String resultURL = performAction(request);

        RequestDispatcher dispatcher = request.getRequestDispatcher( resultURL );
        dispatcher.forward(request, response);
    }

    private  String performAction(HttpServletRequest req) {

        String action = req.getParameter("action");
        Actions obj = actionMap.get(action);

        return obj.executeAcion(req);
    }

}
