package application.lab3.controller;

import application.lab3.controller.UIActions.*;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class UIActionController {
    private static Map<String,Action> procStore = new HashMap<String,Action>();

    public static void initProcStore(String action, Action myClass){
        procStore.put(action,myClass);
    }

    public static Action getProcess(HttpServletRequest req){
       return procStore.get(req.getParameter("action"));
    }

    public static Action refl(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
            Object c = Class.forName(className).newInstance();
        return (Action)c;
    }
}
