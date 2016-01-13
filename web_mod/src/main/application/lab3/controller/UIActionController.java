package application.lab3.controller;

import application.lab3.controller.UIActions.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class UIActionController {
    private static Map<String,Action> procStore = new HashMap<String,Action>();

    private void initProcStore(){
        procStore.put("edit", new NavigateEdit());
        procStore.put("navigation", new NavigateMain());
        procStore.put("help", new NavigateHelp());
        procStore.put("insDept", new NewDepartment());
        procStore.put("insEmp", new NewEmployee());
        procStore.put("empView", new ViewEmployees());
        procStore.put("deptView", new ViewDepartments());
    }

    public static Action getProcess(HttpServletRequest req){
       return procStore.get(req.getParameter("action"));
    }
}
