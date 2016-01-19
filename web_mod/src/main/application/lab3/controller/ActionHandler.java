package application.lab3.controller;

import application.lab3.controller.actions.*;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ActionHandler {
    private static Map<String,Action> procStore = new HashMap<String,Action>();

    public static void initProcStore(String action, Action myClass){
        procStore.put(action,myClass);
    }

    public static Action getProcess(HttpServletRequest req){
       return procStore.get(req.getParameter("action"));
    }

    public static Action getActionObj(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return (Action)Class.forName(className).newInstance();
    }
}
