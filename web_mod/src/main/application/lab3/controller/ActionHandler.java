package application.lab3.controller;

import application.lab3.controller.actions.*;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ActionHandler {
    private  Map<String,Action> procStore = new HashMap<String,Action>();

    public void put(String action, String className)throws ClassNotFoundException, IllegalAccessException, InstantiationException{
        procStore.put(action,(Action)Class.forName(className).newInstance());
    }

    public Action getProcess(HttpServletRequest req){
       return procStore.get(req.getParameter("action"));
    }

}
