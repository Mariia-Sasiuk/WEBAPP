package application.lab3.controller;

import application.lab3.controller.UIActions.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class UIActionController {
    private static Map<String,Action> procStore = new HashMap<String,Action>();

    private void initProcStore(){
        procStore.put("edit", new navigateEdit());
        procStore.put("navigation", new navigateMain());
        procStore.put("help", new navigateHelp());
        procStore.put("insDept", new newDepartment());
        procStore.put("insEmp", new newEmployee());
        procStore.put("empView", new ViewEmployees());
        procStore.put("deptView", new ViewDepartments());
    }

    public static Action getProcess(HttpServletRequest req){
       return procStore.get(req.getParameter("action"));
    }
}
